package basic;

public class Sort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        int index = partition(array, i, j);
        quickSort(array, i, index - 1);
        quickSort(array, index + 1, j);
    }

    private static int partition(int[] array, int i, int j) {
        int pivot = array[i];
        int start = i + 1, end = j;
        while (start < end) {
            while (start < end && array[start] <= pivot) start++;
            while (start < end && array[end] >= pivot) end--;
            if (start >= end) break;
            swap(array, start++, end--);
        }
        if (end == start && array[start] > pivot) {
            swap(array, i, start - 1);
            return start - 1;
        } else {
            swap(array, i, end);
            return end;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void shift(int[] array, int i, int j) {
        while (i < j) {
            swap(array, j - 1, j);
            j--;
        }
    }

    private static void mergeSort(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + (j - i) / 2;
        mergeSort(array, i, mid);
        mergeSort(array, mid + 1, j);
        int a = i, b = mid + 1;
        while (a <= j && b <= j) {
            if (array[a] <= array[b]) {
                a++;
            } else {
                shift(array, a++, b++);
            }
        }
    }
}
