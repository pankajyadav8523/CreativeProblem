import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        SortStack obj = new SortStack();
        Stack<Integer> s = new Stack<>();
        s.push(6);
        s.push(3);
        s.push(1);
        s.push(5);
        s.push(4);
        s.push(-9);
        s.push(8);
        s.push(19);
        
        Stack<Integer> result = obj.sortStack(s);
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
        System.out.println(s.isEmpty());
    }
    Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        while (!s.isEmpty()) {
            int min = minElement(s, s2);
            s3.push(min);  
        }
        return s3;
    }

    int minElement(Stack<Integer> s1, Stack<Integer> s2) {
        int min = Integer.MAX_VALUE;
        while (!s1.isEmpty()) {
            int value = s1.pop();
            if (value < min) {
                min = value;
            }
            s2.push(value);
        }
        boolean minRemoved = false;
        while (!s2.isEmpty()) {
            int value = s2.pop();
            if (value == min && !minRemoved) {
                minRemoved = true;
            } else {
                s1.push(value);
            }
        }
        return min;
    }
}
