

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if(token.equals("+")|| token.equals("-")|| token.equals("*")|| token.equals("/")){
                int operand2=stack.pop();
                int operand1=stack.pop();

                if(token.equals("+")){
                    stack.push(operand1+operand2);

                }else if(token.equals("-")){
                    stack.push(operand1-operand2);
                }else if(token.equals("*")){
                    stack.push(operand1*operand2);
            }else if(token.equals("/")){
                    stack.push(operand1/operand2);
        }

    }else{
        stack.push(Integer.parseInt(token));
    }
}
return stack.peek();
    }
}
