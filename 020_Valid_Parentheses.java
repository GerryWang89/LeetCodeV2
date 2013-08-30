public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            switch(cur){
            case ')':
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(cur);
                break;
            case '}':
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    stack.push(cur);
                break;
            case ']':
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(cur);
                break;
            default:
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }
}