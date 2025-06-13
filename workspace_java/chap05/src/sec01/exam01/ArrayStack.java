package sec01.exam01;

public class ArrayStack {
	private int[] stack;
    private int top;

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.peek()); // 20
//        System.out.println(stack.isEmpty()); // false
		
	}
	
	public ArrayStack(int size) {
        stack = new int[size];
        top = -1; // 스택이 비어 있음
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("스택이 가득 참!");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("스택이 비어 있음!");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("스택이 비어 있음!");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}
