class Solution {
    public long timeTaken(int nums[], int speed){
        long time=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]/speed == 0){
                time+=1;
            }
            else if(nums[i]/speed > 0 && (nums[i]/speed)*speed<nums[i]){
                time += nums[i]/speed + 1;
            }
            else{
                time += nums[i]/speed;
            }
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        int l = 1; 
        int r = max;
        int ans = max;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(timeTaken(piles,mid)>h){
                l = mid+1;
            }
            else{
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }
}
