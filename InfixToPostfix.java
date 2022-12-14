public class InfixToPostfix {
    public InfixToPostfix()
    {
    }
    
    /**
     * takes a infix expression as a string and returns a postfix expression as
     * a string
     * @param infixExpression a string infix expression
     * @return a string postfix expression
     */
    public String convertToPostfix(String infixExpression)
    {
        QueueADT infix = readInfix(infixExpression);
        QueueADT postfix = createPostfix(infix);
        return postfix.toString();
    }

    /**
     * takes a infix expression as a queue and returns a postfix expression as
     * a queue
     * @param infix a infix expression as a queue
     * @return a postfix expression as a queue
     */
    private QueueADT createPostfix(QueueADT infix)
    {
        if (infix.isEmpty())
            throw new IndexOutOfBoundsException("Infix queue is empty.");
    
        infix.enqueue(')');

        StackADT stack = new StackADT();                
        stack.push('(');

        QueueADT postfix = new QueueADT();
        
        // to ensure that the infix expression is valid, we don't want two
        // consecutive digits, or two consecutive operators (excluding
        // parentheses)
        // furthermore, the first and last non-parenthesis character should be a
        // digit
        // To meet these requirements, we use the following bool (initially set
        // to true to ensure first character is a digit)
        boolean lastCharIsOp = true;
        
        while (!stack.isEmpty())
        {
            char currentChar = infix.dequeue();
            // if current char is a digit
            if (isDigit(currentChar))
            {
                if (!lastCharIsOp)
                {
                    throw new IllegalArgumentException(
                        "Infix expression is not valid."
                        );
                }
                postfix.enqueue(currentChar);
                lastCharIsOp = false;
            }
            // if current char is ( 
            else if (currentChar == '(')
                stack.push(currentChar);
            // if current char is an operator
            else if (isOperator(currentChar))
            {
                if (lastCharIsOp)
                {
                    throw new IllegalArgumentException(
                        "Infix expression is not valid."
                        );
                }
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
                lastCharIsOp = true;
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

        if (!infix.isEmpty() || lastCharIsOp)
            throw new IllegalArgumentException(
                "Infix expression is not valid."
                );

        return postfix;
    }
         
    /**
     * checks if given character is a numeric digit
     * @param ch a character
     * @return true if ch is a digit, otherwise false
     */
    public boolean isDigit(char ch)
    {
        return "1234567890".indexOf(ch) >= 0;
    }
    
    /**
     * checks if given character is a valid character
     * @param ch a character
     * @return true if ch is a valid operator, otherwise false
     */
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
    
    /**
     * gives a precedence vale for each operator
     * @param operator an operator character
     * @return the precedence value for the given operator (1 for + or -, 2 for
     * *, /, or %, 3 for ^)
     */
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

    /**
     * reads an infix expression as a string and returns it as a queue
     * @param infixExpression an infix expression as a string
     * @return the infix expression as a string
     */
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
