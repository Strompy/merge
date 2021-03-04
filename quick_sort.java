class Main {
  public static void main(String[] args) {
    // Used for unit testing
    int[] unsortedArray = new int[] {5, 7, 2, 1, 0, 6, 9, 10};

    quickSort(unsortedArray, 0, unsortedArray.length-1);
    printArray(unsortedArray);
  }

  public static void printArray(int[] inputArray) {
    for (int i = 0; i < inputArray.length; i++) {
      System.out.print(inputArray[i] + " ");
    }
    System.out.println();
  }

  public static void quickSort(int[] numbers, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return;
    }
    int pivot = partition(numbers, startIndex, endIndex);
    quickSort(numbers, startIndex, pivot-1);
    quickSort(numbers, pivot+1, endIndex);
  }


  public static int partition(int[] numbers, int low, int high) {
    int pivot = numbers[low];
    int i = low + 1; // number just after pivot
    for (int j = low + 1; j <= high; j++) {
      if (numbers[j] <= pivot) {
        // swap i and j
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        i++;
      }
    }
    // swap i-1 and pivot, to put pivot between low and high lists
    int temp = numbers[i-1];
    numbers[i-1] = numbers[low];
    numbers[low] = temp;

    // return position of pivot/partition
    return i-1;
  }
}
