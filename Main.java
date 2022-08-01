public class Main
{
    public static void main(String[] args)
    {
        StackADT stack = new StackADT();
        stack.push("h");
        stack.push("e");
        stack.push("l");
        stack.push("l");
        stack.push("o");
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