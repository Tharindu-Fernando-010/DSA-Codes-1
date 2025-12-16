/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unbounded.array.stack;

public class UnboundedArrayStack {
    private int[] stack;
    private int top;

    public UnboundedArrayStack() {
        stack = new int[2];
        top = -1;
    }

    // Push with dynamic expansion
    public void push(int x) {
        if (top == stack.length - 1) {
            resize(stack.length * 2);
        }
        stack[++top] = x;
    }

    // Pop with dynamic shrink
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = stack[top--];

        if (top > 0 && top == stack.length / 4) {
            resize(stack.length / 2);
        }

        return value;
    }

    private void resize(int newSize) {
        int[] newStack = new int[newSize];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
