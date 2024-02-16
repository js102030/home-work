package weekly.week4;

public class Main {
    public static void main(String[] args) {
        System.out.println(ParenthesesChecker.isValid("((())())")); // true
        System.out.println(ParenthesesChecker.isValid("(()()))(")); // false
        System.out.println(ParenthesesChecker.isValid("((())")); // false

        System.out.println(ParenthesesChecker.isValid("()(괄호테스트)()")); // true
        System.out.println(ParenthesesChecker.isValid(")(괄호테스트)(")); // false
        System.out.println(ParenthesesChecker.isValid("(((   )")); // false
    }
}
