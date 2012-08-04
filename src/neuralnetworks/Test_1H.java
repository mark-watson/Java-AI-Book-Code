package neuralnetworks;


public class Test_1H {

    static float[] in1 = {0.1f,  0.1f, 0.9f};
    static float[] in2 = {0.1f,  0.9f, 0.1f};
    static float[] in3 = {0.9f,  0.1f, 0.1f};

    static float[] out1 = {0.9f, 0.1f, 0.1f};
    static float[] out2 = {0.1f, 0.1f, 0.9f};
    static float[] out3 = {0.1f, 0.9f, 0.1f};

    static float[] test1 = {0.1f, 0.1f, 0.9f};
    static float[] test2 = {0.1f, 0.9f, 0.1f};
    static float[] test3 = {0.9f, 0.1f, 0.1f};

    public static void main(String[] args) {
        Neural_1H nn = new Neural_1H(3, 3, 3);
        nn.addTrainingExample(in1, out1);
        nn.addTrainingExample(in2, out2);
        nn.addTrainingExample(in3, out3);
        double error = 0;
        for (int i = 0; i < 10000; i++) {
            error += nn.train();
            if (i > 0 && (i % 100 == 0)) {
                error /= 100;
                System.out.println("cycle " + i + " error is " + error);
                error = 0;
            }
        }
        test_recall(nn, test1);
        test_recall(nn, test2);
        test_recall(nn, test3);

        System.out.println("Reload a previously trained NN from disk and re-test:");
        nn.save("test.neural");
        Neural_1H nn2 = Neural_1H.Factory("test.neural");
        // NN is already trained, so just test:
        test_recall(nn2, test1);
        test_recall(nn2, test2);
        test_recall(nn2, test3);
    }

    public static void test_recall(Neural_1H nn, float[] inputs) {
        float[] results = nn.recall(inputs);
        System.out.print("Test case: ");
        for (int i = 0; i < inputs.length; i++) System.out.print(pp(inputs[i]) + " ");
        System.out.print(" results: ");
        for (int i = 0; i < results.length; i++) System.out.print(pp(results[i]) + " ");
        System.out.println();
    }

    public static String pp(float x) {
        String s = new String("" + x + "00");
        int index = s.indexOf(".");
        if (index > -1) s = s.substring(0, index + 3);
        if (s.startsWith("-") == false) s = " " + s;
        return s;
    }
}
