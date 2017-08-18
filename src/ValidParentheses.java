import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != ch)
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();

        System.out.println(v.isValid("()[]{}"));
        System.out.println(v.isValid("([)]"));
    }
}
