package basic;

import org.junit.Test;

import java.util.Random;

public class SortTest {
    @Test
    public void basicTest() {
        int[] array1 = {4, 7, 4, 6, 8, 7, 8, 9, 2, 6, 1, 2, 5, 2, 7};
        Sort.quickSort(array1);
        assert isIncreasing(array1);
        for (int i = 0;i < 10;i++) {
            shuffle(array1);
            Sort.quickSort(array1);
            assert isIncreasing(array1);
        }
        int[] array2 = {4, 7, 4, 6, 8, 7, 8, 9, 2, 6, 1, 2, 5, 2, 7};
        Sort.mergeSort(array2);
        assert isIncreasing(array2);
        for (int i = 0;i < 10;i++) {
            shuffle(array2);
            Sort.mergeSort(array2);
            assert isIncreasing(array2);
        }
    }

    private static boolean isIncreasing(int[] array) {
        for (int i = 1;i < array.length;i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0;i < array.length;i++) {
            swap(array, i, random.nextInt(array.length));
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
