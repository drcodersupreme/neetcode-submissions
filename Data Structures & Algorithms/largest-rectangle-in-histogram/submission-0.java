class Solution {
    public static int[] nextSmallerIdx(int nums[]) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = nums.length;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] previousSmallerIdx(int nums[]) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    public static int largestRectangleArea(int[] heights) {
        int nse[] = nextSmallerIdx(heights);
        int pse[] = previousSmallerIdx(heights);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int width = (nse[i] - pse[i] -1);
            int area = heights[i]*width;
            max = Math.max(area,max);
        }
        return max;
        
    }
}
