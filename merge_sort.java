class Main {
  public static void main(String[] args) {
    // Used for unit testing
    int[] unsortedArray = new int[] {5, 7, 2, 1, 0, 6, 9, 10};

    mergeSort(unsortedArray, 0, unsortedArray.length-1);
    printArray(unsortedArray);
  }

  public static void printArray(int[] inputArray) {
    for (int i = 0; i < inputArray.length; i++) {
      System.out.print(inputArray[i] + " ");
    }
    System.out.println();
  }

  public static void mergeSort(int[] numbers, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      // 1 element
      return;
    }

    int middleIndex = (startIndex + endIndex) / 2;
    mergeSort(numbers, startIndex, middleIndex);
    mergeSort(numbers, middleIndex+1, endIndex);

    // merge
    merge(numbers, startIndex, middleIndex, endIndex);

    return;
  }

  public static void merge(int[] numbers, int startIndex, int middleIndex, int endIndex) {
    int[] firstHalf = new int[middleIndex - startIndex + 1];
    int[] secondHalf = new int[endIndex - middleIndex];
    // copy firstHalf
    for (int i = startIndex; i <= middleIndex; i++) {
      firstHalf[i-startIndex] = numbers[i];
    }
    for (int i = middleIndex + 1; i <= endIndex; i++){
      secondHalf[i-middleIndex-1] = numbers[i];
    }

    // merge lists
    int firstHalfPointer = 0;
    int secondHalfPointer = 0;
    for (int i = startIndex; i <= endIndex; i++){
      if (firstHalfPointer >= firstHalf.length) {
        numbers[i] = secondHalf[secondHalfPointer];
        secondHalfPointer++;
      } else if (secondHalfPointer >= secondHalf.length) {
        numbers[i] = firstHalf[firstHalfPointer];
        firstHalfPointer++;
      } else if (firstHalf[firstHalfPointer] <= secondHalf[secondHalfPointer]) {
        numbers[i] = firstHalf[firstHalfPointer];
        firstHalfPointer++;
      } else {
        numbers[i] = secondHalf[secondHalfPointer];
        secondHalfPointer++;
      }
    }
    return;
  }
}
