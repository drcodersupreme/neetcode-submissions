class Solution {
    public static int trap(int height[]) {
        int prefixMax[] = new int[height.length];
        int suffixMax[] = new int[height.length];

        prefixMax[0] = height[0];
        for (int i = 1; i < suffixMax.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }
        suffixMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }
        int total = 0;
        for (int i = 0; i < suffixMax.length; i++) {
            if (height[i] < prefixMax[i] && height[i] < suffixMax[i]) {
                total += Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }

        }
        return total;
    }
}
