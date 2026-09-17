class Solution {
    public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {

        if (!tokens[i].equals("+") &&
            !tokens[i].equals("-") &&
            !tokens[i].equals("*") &&
            !tokens[i].equals("/")) {

            stack.push(Integer.parseInt(tokens[i]));
        } 
        else {
            int second = stack.pop();
            int first = stack.pop();

            if (tokens[i].equals("+")) {
                stack.push(first + second);
            } 
            else if (tokens[i].equals("-")) {
                stack.push(first - second);
            } 
            else if (tokens[i].equals("*")) {
                stack.push(first * second);
            } 
            else {
                stack.push(first / second);
            }
        }
    }

    return stack.peek();
}
}
