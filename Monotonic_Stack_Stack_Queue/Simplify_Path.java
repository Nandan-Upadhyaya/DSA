import java.util.Stack;
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String part : parts){
            if(part.isEmpty() || part.equals(".")) continue;
            else if(part.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(part);
        }

        StringBuilder sb = new StringBuilder();
        for(String part : stack){
            sb.append("/").append(part);
        }
        return sb.toString().length() > 0 ? sb.toString() : "/";
    }
}