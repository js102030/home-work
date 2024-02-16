package weekly.week4;

import java.util.Stack;

public class ParenthesesChecker {
    public static boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && stack.isEmpty()) {
                return false;
            } else if (c == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
