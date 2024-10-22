import java.util.Stack;

public class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        System.out.println(q.empty());;
    }

    MyQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void enqueue(int value){
        s1.push(value);
    }

    int dequeue(){
        int result = 0;
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        else if (!s2.empty()){
            result = s2.pop();
        }
        else{
            throw new IllegalStateException("Queue is empty.");
        }

        return result;
    }

    int first(){
        int result = 0;
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        else if (!s2.empty()){
            result = s2.peek();
        }
        else{
            throw new IllegalStateException("Queue is empty.");
        }
        return result;
    }

    boolean empty(){
        return s2.empty() && s1.empty();
    }

}
