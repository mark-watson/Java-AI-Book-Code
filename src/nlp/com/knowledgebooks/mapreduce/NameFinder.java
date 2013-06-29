package nlp.com.knowledgebooks.mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nlp.com.knowledgebooks.nlp.util.ScoredList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import nlp.com.knowledgebooks.nlp.ExtractNames;


/**
 * Created by IntelliJ IDEA.
 * User: markw
 * <p/>
 * This is an example Hadoop Map/Reduce application derived from Apache Hadoop examples.
 * It reads the input files, breaks each line into words, checks to see if words are part
 * of proper (human) names) and counts them. The output is a sorted list of human names
 * that occur some minumum number of times in the inpup files.
 * <p/>
 * To run:
 * <p/>
 * bin/hadoop jar namefinder.jar namefinder [-m <i>maps</i>] [-r <i>reduces</i>] <i>in-dir</i> <i>out-dir</i>
 * <p/>
 * Copyright 2002-2013 by Mark Watson. All rights reserved.
 * <p/>
 * This software is not public domain. It can be legally
 * used under the following licenses: LGPL version 3 or Apache 2
 * <p/>
 */
public class NameFinder extends Configured implements Tool {

    private static ExtractNames extractNames = new ExtractNames();

    /**
     * Finds human names and emits them with the document name that they are in.
     */
    public static class MapClass extends MapReduceBase
            implements Mapper<LongWritable, Text, Text, Text> {

        private Text human_name = new Text();
        private Text doc = new Text();

        public void map(LongWritable key, Text value,
                        OutputCollector<Text, Text> output,
                        Reporter reporter) throws IOException {
            String line = value.toString();
            System.err.println("NameFInder: map: key="+key+" line="+line);
            int index = line.indexOf(" ");
            if (index > -1) {
                String doc2 = line.substring(0, index);
                System.err.println("NameFInder: map: doc2="+doc2);
                doc.set(doc2);
                ScoredList [] names_scored_list = extractNames.getProperNames(line.substring(index));
                for (ScoredList name_sc : names_scored_list) {
                    for (String name : name_sc.strings) {
                      Text human_name = new Text();
                      human_name.set(name);
                      output.collect(human_name, doc);
                    }

                }
            }
        }
    }

    /**
     * A reducer class that just emits the sum of the input values.
     */
    public static class Reduce extends MapReduceBase
            implements Reducer<Text, Text, Text, Text> {

        public void reduce(Text person_name, Iterator<Text> documents,
                           OutputCollector<Text, Text> output,
                           Reporter reporter) throws IOException {
            String person = person_name.toString();
            List<String> doc_list = new ArrayList<String>();
            while (documents.hasNext()) {
                Text document = documents.next();
                String document_str = document.toString();
                if (document_str.substring(0, 1).equals("["))
                    document_str = document_str.substring(1, document_str.length() - 1);
                doc_list.add(document_str);
            }
            output.collect(new Text(person), new Text(doc_list.toString()));
        }
    }


    /**
     * The main driver for name finder map/reduce program.
     * <p/>
     * NOTE: copied with modifications from Hadoppjava example programs
     * <p/>
     * Invoke this method to submit the map/reduce job.
     *
     * @throws IOException When there is communication problems with the
     *                     job tracker.
     */
    public int run(String[] args) throws Exception {
        JobConf conf = new JobConf(getConf(), NameFinder.class);
        conf.setJobName("namefinder");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        conf.setMapperClass(MapClass.class);
        //conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);
        List<String> other_args = new ArrayList<String>();
        for (int i = 0; i < args.length; ++i) {
            try {
                if ("-m".equals(args[i])) {
                    conf.setNumMapTasks(Integer.parseInt(args[++i]));
                } else if ("-r".equals(args[i])) {
                    conf.setNumReduceTasks(Integer.parseInt(args[++i]));
                } else {
                    other_args.add(args[i]);
                }
            } catch (Exception ex) {
                System.err.println("ERROR: " + ex);
            }
        }
        FileInputFormat.setInputPaths(conf, other_args.get(0));
        FileOutputFormat.setOutputPath(conf, new Path(other_args.get(1)));
        JobClient.runJob(conf);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new NameFinder(), args);
        System.exit(res);
    }

}
