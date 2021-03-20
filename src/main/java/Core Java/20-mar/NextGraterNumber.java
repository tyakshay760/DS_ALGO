//PS : Find Next greater number with same set of Digits.
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
     Integer num = 534976;
     int[] arr = convertNumToIntegerArr(num);
     // If arr is sorted in desc order than number itself is the biggest number can be formed by same digits
     if(isDSCSorted(arr,arr.length)){
         System.out.println("NOT POSSIBLE");
         return;
     }
     // If arr is sorted in ASC order than to obtained next grater number, we just need to swap last 2 number
     if(isASCSorted(arr,arr.length)){
         swap(arr,arr.length-1,arr.length-2);
         printArray(arr);
         return;
     }
     
     // logic to find the digit which breaks sorting order
     int i= 0;
     for(i = arr.length-1; i >0 ; i--){
         if(arr[i-1] < arr[i]){
             break;
         }
     }
     
     if(i==0){
       System.out.println("NOT POSSIBLE");
     }else{
         // if we found number for which arr[i-1] < arr[i] satisfied then in arr right arr[i-1], find the number which is grater than arr[i-1] 
         // or simple langauge, find the number which is   arr[i-1] < number < arr[i]
         int min = i;
         for(int j = i + 1; j < arr.length; j++){
             if(arr[j] > arr[i-1] && arr[j]<arr[min]){
                 min = j; 
             }
         }
     swap(arr,i-1,min);
     Arrays.sort(arr,i,arr.length);
     printArray(arr);
     }
    }
    
    static void printArray(int[] arr){
     for(int k = 0; k < arr.length; k++){
          System.out.print(arr[k]+" ");
      }
    }
    
    static int[] convertNumToIntegerArr(Integer n){
       int[] arr = new int[n.toString().toCharArray().length];
       int i = arr.length-1;
        while(n > 0){
            int d = n % 10;
            arr[i] = d;
            i--;
            n = n/10;
        }
      return arr;
    }
    
    static int[] swap(int[] arr, int start, int end){
      arr[start] = arr[start] + arr[end];
      arr[end] = arr[start] - arr[end];
      arr[start] = arr[start] - arr[end];
      return arr;
    }
    
    
    
    static boolean isASCSorted(int[] arr, int length){
        if(length == 0 || length < 2){
            return true;
        }
        if(arr[length-1] < arr[length-2]){
            return false;
        }
      return isASCSorted(arr,length-1);
    }
    
    static boolean isDSCSorted(int[] arr, int length){
        if(length == 0 || length < 2){
            return true;
        }
        if(arr[length-1] > arr[length-2]){
            return false;
        }
      return isDSCSorted(arr,length-1);
    }
    
}