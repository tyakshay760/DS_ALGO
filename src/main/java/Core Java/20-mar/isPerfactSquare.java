public class MyClass {
    static int isPerfactSquare(int N,int start, int end){
        int mid = (start+end)/2;
        if(start > end){
          return -1;  
        } 
         if(mid*mid == N){
            return mid; 
         }   
         else if(mid*mid > N){
           return isPerfactSquare(N,start,mid-1);
         }else{
             return isPerfactSquare(N,mid+1,end);
         }  
    }
    
    public static void main(String args[]) {
     int N = 65; 
       System.out.println(isPerfactSquare(N, 1, N)); 
    }
}