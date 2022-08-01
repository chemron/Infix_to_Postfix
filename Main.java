public class Main
{
    public static void main(String[] args)
    {
        stackTesting();
        queueTesting();
    }
    
    public static void queueTesting()
    {
        QueueADT queue = new QueueADT();
        for (char ch: "hello".toCharArray())
            queue.enqueue(ch);
        queue.print();
        System.out.print("dequeue: ");
        System.out.println(queue.dequeue());
        System.out.println("enqueue: !");
        queue.enqueue('!');
        queue.print();
        while (!queue.isEmpty())
        {
            System.out.print("front: ");
            System.out.println(queue.queueFront());
            System.out.print("dequeue: ");
            System.out.println(queue.dequeue());
            queue.print();
        }
    }

    public static void stackTesting()
    {
        StackADT stack = new StackADT();
        for (char ch: "hello".toCharArray())
            stack.push(ch);
        stack.print();
        System.out.print("pop: ");
        System.out.println(stack.pop());
        System.out.println("push: !");
        stack.push('!');
        stack.print();
        while (!stack.isEmpty())
        {
            System.out.print("top: ");
            System.out.println(stack.stackTop());
            System.out.print("pop: ");
            System.out.println(stack.pop());
            stack.print();
        }
    }
}