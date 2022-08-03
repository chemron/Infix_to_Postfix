public class QueueADT {
    private StackADT frontStack;
    private StackADT backStack;

    /**
     * The default constructor for QueueADT
     */
    public QueueADT()
    {
        frontStack = new StackADT();
        backStack = new StackADT();
    }

    /**
     * removes and returns the item at the front of the queue
     * @return the item at the front of the queue
     */
    public char dequeue()
    {
        // if there is at least one element
        // at the front the queue, pop and return it
        if (!frontStack.isEmpty())
            return frontStack.pop();

        // if there are no items in the queue, throw error
        if (backStack.isEmpty())
            throw new IndexOutOfBoundsException("Queue is empty.");

        // otherwise, load elements into the front of the queue, and return the
        // front element
        while (!backStack.isEmpty())
            frontStack.push(backStack.pop());
        
        return frontStack.pop();
    }

    /**
     * adds an item to the back of the queue
     * @param data the item to add
     */
    public void enqueue(char data)
    {
        backStack.push(data);
    }

    /**
     * returns true if queue is empty, false if not
     * @return true if queue is empty, false if not
     */
    public boolean isEmpty()
    {
        return (frontStack.isEmpty() && backStack.isEmpty());
    }

    /**
     * displays the state of the queue
     */
    public void print()
    {
        if (isEmpty())
        {
            System.out.println("Queue is Empty.");
            return;
        }

        System.out.println("Queue:");
        System.out.println(this);
    }

    /**
     * returns the item at the front of the queue
     * @return the item at the front of the queue
     */
    public char queueFront()
    {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Queue is Empty");

        // if front stack is not empty, return the front of the queue
        if (!frontStack.isEmpty())
            return frontStack.stackTop();
        
        // otherwise, load elements into the front of the queue, and return the
        // front element
        while (!backStack.isEmpty())
            frontStack.push(backStack.pop());
        
        return frontStack.stackTop();
    }

    public String toString()
    {
        if (isEmpty())
        {
            return "Queue is Empty.";
        }

        
        StringBuffer buffer = new StringBuffer("");

        // front of queue
        if (!frontStack.isEmpty())
            buffer.append(frontStack);
        
        // if back stack is empty, we are done
        if (backStack.isEmpty())
            return buffer.toString();

        StackADT printStack = new StackADT();
        // create a copy of the backStack so we don't alter it
        StackADT backStackCopy = new StackADT(backStack);
        // load elements from back of queue into the printStack
        while (!backStackCopy.isEmpty())
            printStack.push(backStackCopy.pop());
        
        // rest of queue
        buffer.append(printStack);

        return buffer.toString();
    }
}
