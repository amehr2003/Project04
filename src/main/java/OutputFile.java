import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * o Create a max-heap using the sequential insertions, for those 100 integers.
 * o Output the first 10 integers of your array, into the output file
 * o Output the number of swaps performed, into the output file
 * o Perform 10 removals on the heap
 * o Output the first 10 integers of the resulting array, into the output file
 *
 * o Create a max-heap using the optimal method, for those 100 integers
 * o Output the first 10 integers of your array, into the output file
 * o Output the number of swaps performed, into the output file
 * o Perform 10 removals on the heap
 * o Output the first 10 integers in the resulting array, into the output file
 */

public class OutputFile {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("data_random.txt");
        Scanner fileReader = new Scanner(inputFile);

        List<Integer> dataList = new ArrayList<>();
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter("output.txt"));
            outputWriter.write(", " + );
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creating a MaxHeap with sequential insertions
        System.out.println("================================================");
        System.out.print("Heap using sequential insertions: " + printHeapValues(););
        System.out.print("Number of swaps in the heap creation: " + MaxHeap.numSwaps);
        System.out.print("Heap after ten removals " + printHeapValues(););

        System.out.print("Heap using sequential insertions: " + );
        System.out.print("Number of swaps in the heap creation: " + MaxHeap.oNumSwaps);
        System.out.print("Heap after ten removals " + );
        System.out.println("================================================");
    }
}