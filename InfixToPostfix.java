public class InfixToPostfix {
    public InfixToPostfix()
    {
    }
    
    public String convertToPostfix(String infixExpression)
    {
        QueueADT infix = readInfix(infixExpression);
        QueueADT postfix = createPostfix(infix);
        return postfix.toString();
    }

    private QueueADT createPostfix(QueueADT infix)
    {
        if (infix.isEmpty())
            throw new IndexOutOfBoundsException("Infix queue is empty.");
    
        infix.enqueue(')');

        StackADT stack = new StackADT();                
        stack.push('(');

        QueueADT postfix = new QueueADT();     
        
        while (!stack.isEmpty())
        {
            char currentChar = infix.dequeue();
            // if current char is a digit
            if (isDigit(currentChar))
            postfix.enqueue(currentChar);
            // if current char is ( 
            else if (currentChar == '(')
            stack.push(currentChar);
            // if current char is an operator
            else if (isOperator(currentChar))
            {
                char topChar = stack.stackTop();
                while (isOperator(topChar))
                {
                    if (precedence(topChar, currentChar))
                    {
                        postfix.enqueue(stack.pop());
                    topChar = stack.stackTop();
                    }
                    else break;
                }
                stack.push(currentChar);
            }
            // if current char is )
            else if (currentChar == ')')
            {
                while (stack.stackTop() != '(')
                postfix.enqueue(stack.pop());
                // discard left parenthesis
                stack.pop();
            }
            // if current char is not valid
            else
                throw new IllegalArgumentException(
                    "Character: " + currentChar + " is not valid."
                    );
        }

        return postfix;
    }
                
    public boolean isDigit(char ch)
    {
        return "1234567890".indexOf(ch) >= 0;
    }
    
    public boolean isOperator(char ch)
    {
        return "+-*/%^".indexOf(ch) >= 0;
    }
    
    /**
     * returns true if operator1 has a precedence greater than or equal to
     * operator2, otherwise return false
     * @param operator1 the first operator char
     * @param operator2 the second operator char
     * @return true if operator1 has a precedence greater than or equal to
     * operator2, otherwise false
     */
    public boolean precedence(char operator1, char operator2)
    {
        return precedenceValue(operator1) >= precedenceValue(operator2);
    }
    
    public int precedenceValue(char operator)
    {
        switch (operator)
        {
            case '+': case '-':
                return 1;
            case '*': case '/': case '%':
                return 2;
            case '^':
                return 3;
            default:
                throw new IllegalArgumentException(
                    "Character: " + operator + " is not a valid operator."
                    );
        }
    }

    private QueueADT readInfix(String infixExpression)
    {
        QueueADT infix = new QueueADT();
        for (char ch: infixExpression.toCharArray())
        {
            infix.enqueue(ch);
        }
        return infix;
    }
}
