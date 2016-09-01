package basic;

public class Sort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] backup = new int[array.length];
        mergeSort(array, 0, array.length - 1, backup);
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

    private static void mergeSort(int[] array, int i, int j, int[] backup) {
        if (i == j) {
            return;
        }
        int mid = i + (j - i) / 2;
        mergeSort(array, i, mid, backup);
        mergeSort(array, mid + 1, j, backup);
        int a = i, b = i, c = mid + 1;
        while (b <= mid && c <= j) {
            if (array[b] > array[c]) {
                backup[a++] = array[c++];
            } else {
                backup[a++] = array[b++];
            }
        }
        while (b <= mid) {
            backup[a++] = array[b++];
        }
        while (c <= j) {
            backup[a++] = array[c++];
        }
        System.arraycopy(backup, i, array, i, j - i + 1);
    }
}
