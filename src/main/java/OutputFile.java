import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutputFile  {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("data_random.txt");
        Scanner fileReader = new Scanner(inputFile);

        ArrayList<Integer> dataList = new ArrayList<>();
        ArrayList<Integer> smartDataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.optimalAdd(Integer.valueOf(fileReader.nextInt()));
            //dataList.optimalAdd(i);
            //dataList.add(i, Integer.valueOf(fileReader.nextInt()));
        }

        for (int i = 0; i < 100; i++) {
            smartDataList.add(Integer.valueOf(fileReader.nextInt()));

        /*
        BufferedReader inputReader = new BufferedReader(new FileReader("data_random.txt"));
        try {
            for (int i=0; i<100; i++)
            {
                dataList.set(i, Integer.valueOf(inputReader.readLine()));
            }
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

            //regular add method
            try {
                BufferedWriter outputWriter = new BufferedWriter(new FileWriter("output.txt"));
                outputWriter.write("================================================");
                outputWriter.write("\n, Heap using sequential insertions: ");

                for (int j = 0; j <= 10; j++) {
                    outputWriter.write(dataList.get(j) + ", ");
                }

                outputWriter.write("\n Number of swaps in the heap creation: " + MaxHeap.numSwaps);
                outputWriter.write("\n Heap after 10 removals ");
                for (int k = 0; k <= 10; k++) {
                    dataList.remove(k);
                    outputWriter.write(dataList.get(k) + ", ");
                }


                //optimal method
                outputWriter.write("\n, Heap using sequential insertions: ");
                for (int l = 0; l <= 10; l++) {
                    outputWriter.write(smartDataList.get(l) + ", ");
                }
                outputWriter.write("\n Number of swaps in the heap creation: " + MaxHeap.oNumSwaps);
                outputWriter.write("\n Heap after 10 removals ");

                for (int m = 0; m <= 10; m++) {
                    smartDataList.remove(m);
                    outputWriter.write(smartDataList.get(m) + ", ");
                }
                outputWriter.write("\n ================================================");
                outputWriter.close();
            } catch (IOException r) {
                r.printStackTrace();
            }
        }

    }
}

