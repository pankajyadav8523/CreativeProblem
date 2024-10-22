public class LinkedList {
    Node head;
    int size;


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(-889);
        ll.addFirst(1000);
        ll.addFirst(8);
        ll.addFirst(5);
        ll.removeCycle();
        // ll.selectionSort();
        ll.printLinkedList();
    }


    public LinkedList(){
        head = null;
        size = 0;
    }


    public Node reverseLinkedList(){ 
        Node curr = head;
        Node prev = null;
        while (curr != null){
            Node next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        head = prev;
        return head;
    }


    public void printLinkedList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }


    public int deleteAtPosition(int index){
        Node curr = head;
        int result;
        int i = 1;
        if (index == 1){
            result = deleteFirst();
        }
        else{
            while (i < index-1){
                curr = curr.next;
                i++;
            }
            result = curr.next.value;
            curr.next = curr.next.next;
        }
        return result;
    }


    public void deleteNodeRef(int value){
        Node curr = new Node(value);
        curr.value = curr.next.value;
        curr.next = curr.next.next;
    }


    public void addFirst(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size ++;
    }


    public void addLast(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size ++;
    }


    public int deleteLast(){
        if (size == 0){
            return -1;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        int result = temp.value;
        size --;
        return result;
    }


    public void selectionSort(){
        Node curr = head;
        while (curr != null){
            Node min = minRef(curr);
            int minValue = min.value;
            min.value = curr.value;
            curr.value = minValue;
            curr = curr.next;
        }
    }

    private Node minRef(Node curr){
        int value = Integer.MAX_VALUE;
        Node min = new Node(value);
        while (curr != null){
            if (curr.value < min.value){
                min = curr;
            }
            curr = curr.next;
        }
        return min;
    }

    public int deleteFirst(){
        if (size == 0){
            return -1;
        }
        int result = head.value;
        head = head.next;
        size --;
        return result;
    }


    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
    
        // Step 1: Detect cycle using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
    
            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false;  // No cycle detected
    }
    
    public void removeCycle() {
        // Step 2: Check if the cycle exists
        if (isCycle()) {
            // If a cycle exists, find and remove it
            startNode();
        } else {
            System.out.println("Cycle doesn't exist");
        }
    }
    
    public void startNode() {
        Node slow = head;
        Node fast = head;
    
        // Step 3: Detect the meeting point inside the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
    
            if (slow == fast) {
                break;  // The cycle is detected
            }
        }
    
        // Step 4: Move slow pointer to head and keep fast at meeting point
        slow = head;
    
        // Step 5: Move both slow and fast one step at a time until they meet at the start of the cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
    
        // Step 6: Find the node that points to the start of the cycle and break the cycle
        Node curr = fast;
        while (curr.next != slow) {
            curr = curr.next;
        }
        curr.next = null;  // Break the cycle
    }
    

    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    private class Node{
        int value;
        Node next;
        public Node(int v){
            this.value = v;
        }
    }
}