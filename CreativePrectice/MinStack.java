import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        MinStack ms = new MinStack();
        ms.pushElement(s1, 6, s2);
        ms.pushElement(s1, 3, s2);
        ms.pushElement(s1, 1, s2);
        ms.pushElement(s1, 5, s2);
        ms.pushElement(s1, -9, s2);
        ms.pushElement(s1, 12, s2);
        ms.pushElement(s1, 0, s2);
        System.out.println(ms.minStack(s2));
    }
    void pushElement(Stack<Integer> s1, int value, Stack<Integer> s2){
        s1.push(value);
        if (s2.empty()){
            s2.push(value);
        }
        else{
            if(s2.peek() >= value){
                s2.push(value);
            }
        }
    }

    int removeElement(Stack<Integer> s1, Stack<Integer> s2){
        int result  = s1.pop();
        if (result == s2.peek()){
            s2.pop();
        }
        return result;
    }
    int minStack(Stack<Integer> s2){
        /*
         * Input : 1, 4, 5, 2, 5
         * Output : 1
         */
        return s2.peek();
    }


    public void implementing3Stack(int[] arr){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Integer> a3 = new ArrayList<>();
        
    }
}
