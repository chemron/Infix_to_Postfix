/**
 * This class defines a stack capable of storing strings
 */
public class StackADT
{
    public static class StackNode
    {
        private String data;
        private StackNode next;

        /**
         * the default constructor for StackNode
         */
        public StackNode()
        {
        }

        /**
         * accessor method for data
         * @return the data String
         */
        public String getData()
        {
            return data;
        }

        /**
         * accessor method for the next node
         * @return the next StackNode
         */
        public StackNode getNext()
        {
            return next;
        }

        /**
         * Mutator method to set the data
         * @param data a string we want to store in the current StackNode
         */
        public void setData(String data)
        {
            this.data = data;
        }

        /**
         * Mutator method to set the next Node
         * @param next the StackNode that will be next
         */
        public void setNext(StackNode next)
        {
            this.next = next;
        }
    }
    private StackNode top;

    /**
     * the default constructor for StackADT
     */
    public StackADT()
    {
    }

    /**
     * the copy constructor for StackADT
     */
    public StackADT(StackADT anotherStack)
    {
        this.top = anotherStack.top;
    }

    /**
     * checks if the stack is empty
     * @return true if the stack is empty, otherwise false
     */
    public boolean isEmpty()
    {
        return (top == null);
    }

    /**
     *  pops the top value from the stack
     *  @return the data at the top of the stack
     */
    public String pop()
    {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty.");
        
        String value = top.getData();
        top = top.getNext();
        return value;
    }

    /**
     * prints the contents of the stack
     */
    public void print()
    {
        if (isEmpty())
        {
            System.out.println("Stack is Empty.");
            return;
        }

        System.out.println("Stack:");
        StackNode nd = top;
        while (nd != null)
        {
            System.out.println("\t" + nd.data);
            nd = nd.getNext();
        }
    }

    /**
     * pushes data on to the top of the stack
     * @param data the string to be pushed to the stack
     */
    public void push(String data)
    {
        StackNode newTop = new StackNode();
        newTop.setData(data);
        newTop.setNext(top);

        top = newTop;
    }

    /**
     * gets the data at the top of the stack
     * @return the data at the top of the stack.
     */
    public String stackTop()
    {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty.");

        return top.getData();
    }
}
