public class Testing {
    public static void main(String[] args)
    {
        infixToPostfixTesting();
    }

    /**
     * tests infix to postfix conversion
     */
    public static void infixToPostfixTesting()
    {
        InfixToPostfix objInfixToPostfix = new InfixToPostfix();

        String[] validInfix = {
            "(6+2)*5-8/4",
            "0-(7%1)+9^3"
        };
        String[] validPostfix = {
            "62+5*84/-",
            "071%-93^+"
        };
        String[] invalidInfix = {
            "+32+/4*2",
            "2+a-d5"
        };

        // test valid infix
        for (int i = 0; i < validInfix.length; i++)
        {
            String infix = validInfix[i];
            System.out.println("Infix is: " + infix);
            String postfix = objInfixToPostfix.convertToPostfix(infix);
            System.out.println("Postfix is: " + postfix);
          
            if (postfix.equals(validPostfix[i]))
                System.out.println("Test passed!");
            else
            {
                System.out.println("Test failed!");
                System.out.println("Correct answer was: " + validPostfix[i]);
            }
            System.out.println();
        }

        // test invalid infix
        for (int i = 0; i < invalidInfix.length; i++)
        {
            String infix = invalidInfix[i];
            System.out.println("Infix is: " + infix);
            
            boolean caught = false;

            try
            {
                objInfixToPostfix.convertToPostfix(infix);
            }
            catch (Exception e)
            {
                System.out.println(
                    "Test passed, the error: " + e + " was encountered"
                );
                caught = true;
            }
            if (!caught)
                System.out.println("Test failed, no errors were encountered");
            System.out.println();
        }
    }  
}
