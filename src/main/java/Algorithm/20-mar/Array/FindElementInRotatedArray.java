/**
 * statement: We rotate an ascending order sorted array at some point unknown to user. So for instance, 3 4 5 6 7 might become 5 6 7 3 4. Modify binary search algorithm to find an element in the rotated array in O(log n) time and O(1) Space complexity
 * steps:  
 * Algorithm: approach recursive approach.
 * 1. find the mid element index, and compare if the given value is equals to the value at middle index, if yes, return mid;
 * 2. If value != arr[mid], then find that which side of the array is sorted 
 * exm: if arr[0] < arr[mid-1] 
 * and if arr[mid] > value search in the left array -> 0 to mid-1, else search in right array i.e mid+1 to high
 * 3. if left array is not sorted  then right array must be sorted, so 
 * now check if value > arr[mid] than search in mid+1 to high else search b/w low to mid-1;
 * 
 */ 

 /**
 * statement: We rotate an ascending order sorted array at some point unknown to user. So for instance, 3 4 5 6 7 might become 5 6 7 3 4. Modify binary search algorithm to find an element in the rotated array in O(log n) time and O(1) Space complexity
 * steps:  
 * Algorithm: approach recursive approach.
 * 1. find the mid element index, and compare if the given value is equals to the value at middle index, if yes, return mid;
 * 2. If value != arr[mid], then find that which side of the array is sorted 
 * exm: if arr[0] < arr[mid-1] 
 * and if arr[mid] > value search in the left array -> 0 to mid-1, else search in right array i.e mid+1 to high
 * 3. if left array is not sorted  then right array must be sorted, so 
 * now check if value > arr[mid] than search in mid+1 to high else search b/w low to mid-1;
 * 
 */ 

public class FindElementInRotatedArray{
      
    public static void main(String[] args){
        int[] arr = {3,4,5,6,1,2};
        FindElementInRotatedArray f = new FindElementInRotatedArray();
        int index = f.findElement(arr,0,arr.length-1,2);
        if(index != -1){
            System.out.println("element found at index = "+index);
        }else{
         System.out.println("element not found in the array ");
        }
 
     }

    public int findElement(int[] arr, int start, int end, int value){
        if(start > end){
            return -1;
        }
        int mid = (start+end)/2;

        if(arr[mid] == value){
            return mid;
        }

        if(arr[start] <= arr[mid]){
           if(value >= arr[start] &&  value <= arr[mid] ){
               return findElement(arr, start, mid-1, value);
           }else{
               return findElement(arr, mid+1, end, value);
           }

        }
        if(arr[mid] <= value && arr[end] >= value){
            findElement(arr, mid+1, end, value);
        }
       return findElement(arr, start , mid-1,value);     
    }
 }