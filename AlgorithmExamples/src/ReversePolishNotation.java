import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Queue<String> queue = new ArrayDeque<>(Arrays.asList(tokens));
        Stack<String> stack = new Stack<>();
        int firstOperand;
        int secondOperand;
        int result = 0;
        List<String> operators = Arrays.asList("+","-","*","/");

        while (!queue.isEmpty()) {

            if(!operators.contains(queue.peek())) {
                stack.push(queue.remove());
            }
            else {
                firstOperand = Integer.parseInt(stack.pop());
                secondOperand = Integer.parseInt(stack.pop());

                switch (queue.peek()) {
                    case "+" -> result = secondOperand + firstOperand;
                    case "-" -> result = secondOperand - firstOperand;
                    case "*" -> result = secondOperand * firstOperand;
                    case "/" -> result = secondOperand / firstOperand;
                }
                stack.push(String.valueOf(result));
                queue.remove();
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=daily-question&envId=2024-01-30

        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
