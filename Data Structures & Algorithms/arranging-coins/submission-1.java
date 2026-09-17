class Solution {
    public int arrangeCoins(int n) {
        long i = 1;
        while((long)(i*(i+1)/2) <= (long)n){
            i++;
        }
      
      return (int)i-1;
    }
}
