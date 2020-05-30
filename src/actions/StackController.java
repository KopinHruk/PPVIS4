package src.actions;

import java.util.Stack;

import src.validator.InfixToPostfix;

public class StackController implements ActionInterface {

    private static StackController calculator;

    public static StackController getCalculator() {
        return calculator;
    }

    private double answer;

    public StackController() {
        this.calculator = this;
    }

    private void calculate() {
        String input = ActionInterfaceText.getTextField().getText().getText();
        var operands = InfixToPostfix.Convert(input);
        Stack<Double> stack = new Stack<>();
        for (var operand : operands) {
            switch(operand) {
                case "+":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(firstOperand + secondOperand);
                }
                break;
                case "-":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand - firstOperand);
                }
                break;
                case "*":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(firstOperand * secondOperand);
                }
                break;
                case "/":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand / firstOperand);
                }
                break;
                case "%":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand % firstOperand);
                }
                break;
                case "!":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(Math.pow(secondOperand, firstOperand));
                }
                break;
                case "@":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.pow(Math.E, firstOperand));
                }
                break;
                case "":
                break;
                default:
                stack.push(Double.parseDouble(operand));
                break;
            }
        }
        answer = stack.pop();
    }

    public double getAnswer() {
        return answer;
    }

    @Override
    public void action() {
        calculate();
    }
}