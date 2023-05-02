package EX_3;

import java.util.Arrays;
import java.util.Scanner;

public class EX_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("размер массива: ");
        int s = iScanner.nextInt();
        iScanner.close();
        int[] array = new int[s];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 30));

        }
        System.out.println(Arrays.toString(array));
        HeapSort(array, s);
    }

    private static void HeapSort(int[] array, int s) {
        int temp;
        int size = s - 1;
        for (int i = (s / 2); i >= 0; i--) {
            hf(array, i, size);
        }
        ;
        for (int i = size; i >= 0; i--) {
            temp = array[0];
            array[0] = array[size];
            array[size] = temp;
            size--;
            hf(array, 0, size);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void hf (int [] array, int j, int size) {
        int a = 2*j;
        int b = 2*j+1;
        int largestElement;
        if (a <= size && array[a] > array[j]) {
           largestElement = a;
        } else {
           largestElement = j;
        }
        if (b <= size && array[b] > array[largestElement]) {
           largestElement = b;
        }
        if (largestElement != j) {
           int temp = array[j];
           array[j] = array[largestElement];
           array[largestElement] = temp;
           hf(array, largestElement, size);
       }
    }
}
