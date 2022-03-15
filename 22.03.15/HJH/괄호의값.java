import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int sum = 1;
        int ans = 0;
        int c2 = 0;
        int c3 = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    stack.push('(');
                    sum *= 2;
                    break;
                case '[':
                    stack.push('[');
                    sum *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        ans = 0;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                    	stack.pop();
                    	stack.push('2');
                    	c2++;
                    	ans += sum;
                    }
                    stack.pop();
                    sum /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        ans = 0;
                        break;
                    }

                    if (str.charAt(i - 1) == '[') {
                    	stack.pop();
                    	stack.push('3');
                    	c3++;
                    	ans += sum;
                    }
                    stack.pop();
                    sum /= 3;
                    break;
            }
        }
        int answer = 0;
        answer = (int) (Math.pow(2,c2) + Math.pow(3, c3));
        System.out.println(!stack.isEmpty() ? 0 : answer);
    }
}
