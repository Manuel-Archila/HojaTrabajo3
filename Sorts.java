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
  
}
