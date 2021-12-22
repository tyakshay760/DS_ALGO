/**
 * PS : Move all the zero element in given array to the end of the array
 * concept: 
 * 1. take two pointer 
 * one to keep track of non zero element exm cnt = 0 and another to traverse the array i = 0
 * 2. During the traversal, move all the non zero element to the left of the array 
 *  so when you encounter non zero element replace that element with non zero variable index and increase nonxero counter to +1.. .exm arr[cnt] = arr[i]; then cnt++; 
 * once traversal is done,
 * then interate cnt till the lenght of the array and replace all the element with 0
 * 
 */
public class MoveAllZeroToEnd { 
    static void MoveZeroToEnd(int array[], int n) 
    { 
       int cnt = 0;
        for(int i=0; i < array.length; i++){
             if(array[i] != 0){
                  array[cnt++] = array[i];
             }
        }
        
        while(cnt < n){
            array[cnt++] = 0;
            cnt++;
        }
    } 
    
   
  
    public static void main (String[] args) 
    { 
        int array[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}; 
        int n = array.length; 
        MoveZeroToEnd(array, n); 
        System.out.println("result is: "); 
        for (int i=0; i<n; i++) 
            System.out.print(array[i]+" "); 
    } 
}

/* Try more Inputs
case1:
 actual = MoveZeroToEnd([1,3,0,0,4,0,9],7)
 expected = [1,3,4,9,0,0,0]
 
case2:
actual = MoveZeroToEnd([0,1,0,3,12],5)
expected = [1,3,12,0,0]

case3:
actual = MoveZeroToEnd([0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9],13)
expected = [1,9,8,4,2,7,6,9,0,0,0,0,0]

*/