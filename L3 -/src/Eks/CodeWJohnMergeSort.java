package Eks;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CodeWJohnMergeSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[]numbers = new int [100000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000000)+1;

        }
        System.out.println("before");
        System.out.println(Arrays.toString(numbers));

        fletteSort(numbers);

        System.out.println("after");
        System.out.println(Arrays.toString(numbers));
    }

    //metode som sætter fletningen i gang
    public static void fletteSort(int[] list) {
        mergeSort(list);

    }

    //den rekursive metode der implementerer del-loes og kombiner skabelonen
    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }
        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //merge
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize) {

            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //tjekker de sidste tal i listen (højre eller venstre) når der ikke længere kan sammenlignes
        while (i<leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j<rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
