class Solution {
    public static int carFleet(int target, int[] position, int[] speed) {
        int arr[][] = new int[speed.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                double t1 = (double)(target - arr[i][0]) / (arr[i][1]);
                double t2 = (double)(target - stack.peek()[0]) / (stack.peek()[1]);
                if (t1 <= t2) {
                    continue;
                }

            }
            stack.push(new int[] { arr[i][0], arr[i][1] });

        }
        return stack.size();

    }
}
