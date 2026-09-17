class Solution {
    

public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    
    String[] parts = path.split("/");

    for (String part : parts) {
        if (part.equals("") || part.equals(".")) {
            continue;  // ignore empty and current directory
        } 
        else if (part.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();  // go back one directory
            }
        } 
        else {
            stack.push(part);  // normal directory name
        }
    }

    // Build final path
    StringBuilder result = new StringBuilder();

    for (String dir : stack) {
        result.append("/").append(dir);
    }

    return result.length() == 0 ? "/" : result.toString();
}
}