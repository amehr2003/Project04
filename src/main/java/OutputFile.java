import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutputFile {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("data_random.txt");
        Scanner fileReader = new Scanner(inputFile);

        //MaxHeap<Integer> dataList = new MaxHeap<>();
        ArrayList<Integer> dataList = new ArrayList<>();
        ArrayList<Integer> smartDataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.add(Integer.valueOf(fileReader.nextInt()));
            //dataList.optimalAdd(i);
            //dataList.add(i, Integer.valueOf(fileReader.nextInt()));
        }

        for (int i = 0; i < 100; i++) {
            smartDataList.optimalAdd(Integer.valueOf(fileReader.nextInt()));
            //dataList.optimalAdd(i);
            //dataList.add(i, Integer.valueOf(fileReader.nextInt()));

            //inputFile.close();

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

                for (int i = 0; i <= 10; i++) {
                    outputWriter.write(dataList.get(i) + ", ");
                }

                outputWriter.write("\n Number of swaps in the heap creation: " + MaxHeap.numSwaps);
                outputWriter.write("\n Heap after 10 removals ");
                for (int i = 0; i <= 10; i++) {
                    dataList.remove(i);
                    outputWriter.write(dataList.get(i) + ", ");
                }


                //optimal method
                outputWriter.write("\n, Heap using sequential insertions: ");
                for (int i = 0; i <= 10; i++) {
                    outputWriter.write(smartDataList.get(i) + ", ");
                }
                outputWriter.write("\n Number of swaps in the heap creation: " + MaxHeap.oNumSwaps);
                outputWriter.write("\n Heap after 10 removals ");

                for (int i = 0; i <= 10; i++) {
                    smartDataList.remove(i);
                    outputWriter.write(smartDataList.get(i) + ", ");
                }
                outputWriter.write("\n ================================================");
                outputWriter.close();
            } catch (IOException r) {
                r.printStackTrace();
            }
        }

    }
}
