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

        // create copies of the stacks so we don't alter them while printing
        StackADT printFrontStack = new StackADT(frontStack);
        StackADT printBackStack = new StackADT(backStack);

        System.out.println("Queue:");
        // if front stack is not empty, print the front of the queue first
        while (!printFrontStack.isEmpty())
        {
            System.out.println("\t" + printFrontStack.pop());
        }

        // load elements from back of queue into the front of the queue
        while (!printBackStack.isEmpty())
            printFrontStack.push(printBackStack.pop());
        
        // print rest of queue
        while (!printFrontStack.isEmpty())
        {
            System.out.println("\t" + printFrontStack.pop());
        }
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
}
