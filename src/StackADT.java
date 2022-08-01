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
    private int size;

    /**
     * the default constructor for StackADT
     */
    public StackADT()
    {
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
        size++;
    }

    public static void main(String[] args)
    {
        StackADT stack = new StackADT();
        stack.push("hello");
    }
}
