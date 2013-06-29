# new: gunzip files one at a time:

match = "3gram"
CUTOFF = 500

$words = "====="
$count = 0

$out = File.new("/home/markw/#{match}.txt", 'w')

File.new("ngrams_uris.txt").lines.each do |line|
  if line.index("<a href='") && line.index(match)
    uri = line[9...line.index("'>")]
    puts "|#{uri}|"
    `wget #{uri}`
    sleep 60

    Dir.entries(".").each do |fn|
      if fn.index(match) && fn.index(".gz")
        file_root = fn[0..-4]
        puts `gunzip #{fn}`
        sleep 20
        puts `ls -lh #{file_root}*`
        count = 0
        File.new(file_root).each_line.each do |line|
          count += 1
          tokens = line.split("\t")
          if tokens[1].size > 0
            #puts tokens.join("|")
            words = tokens[0].downcase.split.collect do |w|
              index = w.index("_")
              if w.length<2 || w[0]=="_" || w[0]=="(" || w[0]==")" || w[0]=="." || w[0]=="'"
                "^"
              elsif index
                w[0...index]
              else
                w
              end 
            end.join(' ')
            if $words == words
              $count += tokens[2].to_i if !words.index("^")
            else
              $out.puts "#{$words}\t#{$count}" if $words != "=====" && !$words.index("^") && $count > 20 && !$words.index(",") && !$words.index(".")  && !$words.index(";") && !$words.index(":") && !$words.index("!")  && $words[0]!="0" && $words[0].to_i==0 if $count > CUTOFF
              $words = words
              $count = tokens[2].to_i
            end
          end
        end
        puts "count=#{count} for #{file_root}"
        puts `rm -r -f  *#{file_root}*`
      end
    end
  end
end
$out.close
