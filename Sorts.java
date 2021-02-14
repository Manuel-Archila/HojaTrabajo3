import java.util.Arrays;
public class Sorts {

  private int partitionqS(Comparable<Integer>[] arr, int low, int high) { 
    int pivot = (Integer)arr[high];  
    int i = (low-1); // index of smaller element 
    for (int j=low; j<high; j++) { 
      // If current element is smaller than the pivot 
      if ((arr[j].compareTo(pivot)) == -1){ 
          i++; 

          // swap arr[i] and arr[j] 
          int temp =(Integer)arr[i]; 
          arr[i] = arr[j]; 
          arr[j] = temp; 
      }
    } 

    // swap arr[i+1] and arr[high] (or pivot) 
    int temp =(Integer)arr[i+1]; 
    arr[i+1] = arr[high]; 
    arr[high] = temp; 

    return i+1; 
    }


  public void quicksort(Comparable<Integer>[] arr, int low, int high){
    if (low < high) { 
      /* pi is partitioning index, arr[pi] is  
        now at right place */
      int pi = partitionqS(arr, low, high); 

      // Recursively sort elements before 
      // partition and after partition 
      quicksort(arr, low, pi-1); 
      quicksort(arr, pi+1, high); 
    } 
  }

  // A utility function to get maximum value in arr[] 
  private int getMax(Comparable<Integer>[] arr, int n) 
  { 
    int mx =(Integer) arr[0]; 
    for (int i = 1; i < n; i++){
      if (arr[i].compareTo(mx) == 1){ 
        mx = (Integer)arr[i];
      }
    }
    return mx; 
  } 

  // A function to do counting sort of arr[] according to 
  // the digit represented by exp. 
  private void countSort(Comparable<Integer>[] arr, int n, int exp){ 
    int output[] = new int[n]; // output array 
    int i; 
    int count[] = new int[10]; 
    Arrays.fill(count, 0); 

    // Store count of occurrences in count[] 
    for (i = 0; i < n; i++){
      count[((Integer)arr[i] / exp) % 10]++; 
    }

    // Change count[i] so that count[i] now contains 
    // actual position of this digit in output[] 
    for (i = 1; i < 10; i++){
      count[i] += count[i - 1]; 
    }
    // Build the output array 
    for (i = n - 1; i >= 0; i--) { 
      output[count[((Integer)arr[i] / exp) % 10] - 1] =(Integer) arr[i]; 
      count[((Integer)arr[i] / exp) % 10]--; 
    } 

    // Copy the output array to arr[], so that arr[] now 
    // contains sorted numbers according to curent digit 
    for (i = 0; i < n; i++){
      arr[i] = output[i];
    }
  }


  // The main function to that sorts arr[] of size n using 
  // Radix Sort 
  public void radixsort(Comparable<Integer>[] arr, int n) 
  { 
    // Find the maximum number to know number of digits 
    int m = getMax(arr, n); 

    // Do counting sort for every digit. Note that 
    // instead of passing digit number, exp is passed. 
    // exp is 10^i where i is current digit number 
    for (int exp = 1; m / exp > 0; exp *= 10){
      countSort(arr, n, exp); 
    }
  }

  public void gnomeSort(Comparable<Integer>[] arr){
    for (int i = 1; i < arr.length;){

      int com =(Integer) arr[i];
      if(arr[i-1].compareTo(com) <= 0){
        i++;

      }else{
        int tempArr = (int) arr[i-1];
        arr[i-1] = arr[i];
        arr[i] = tempArr;
        i--;
;      }
      if(i == 0){
        i=1;
      }
    }
  }

  public Integer[] mergeSort(Comparable<Integer>[] arr){
    if(arr.length <= 1){
      return (Integer[]) arr;
    }
    int midpoint = arr.length /2;
    Integer[] left = new Integer[midpoint];
    Integer[] right;

    if(arr.length % 2 ==0){
      right = new Integer[midpoint];
    }else{
      right = new Integer[midpoint +1];
    }

    for(int i=0; i < midpoint; i++){
      left[i] = (Integer) arr[i];
    }
    for(int j=0; j < right.length; j++){
      right[j] = (Integer) arr[midpoint + j];
    }

    Integer[] result = new Integer[arr.length];
    left = mergeSort(left);
    right = mergeSort(right);
    result = merge(left, right);

    return result;
  }

  public Integer[] merge(Comparable<Integer>[] left, Comparable<Integer>[] right){
    Integer[] result = new Integer[left.length + right.length];

    int leftPointer, rightPointer, resultPointer;
    leftPointer = rightPointer = resultPointer = 0;

    while(leftPointer < left.length || rightPointer < right.length){

      if(leftPointer < left.length && rightPointer < right.length){
        int rp = (Integer) right[rightPointer];
        if(left[leftPointer].compareTo(rp) < 0){
          result[resultPointer++] = (Integer) left[leftPointer++];
        }else{
          result[resultPointer++] = (Integer) right[rightPointer++];
        }
      }

      else if(leftPointer < left.length){
        result[resultPointer++] = (Integer) left[leftPointer++];
      } else if(rightPointer < right.length){
        result[resultPointer++] = (Integer) right[rightPointer++];
      }
    }

    return result;
  }

  public void swap(Comparable<Integer>[] arr, int left, int right){

    int temp = (int) arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  public void selectionSort(Comparable<Integer>[] arr){
    int min;

    for(int i=0; i < arr.length -1; i++){
      min = i;

      for(int j=i+1; j<arr.length; j++){
        int m = (Integer) arr[min];
        if(arr[j].compareTo(m) < 0){
          min = j;
        }
      }
      if(min != i){
        swap(arr, i, min);
      }
    }
  }

}


