package stack;

import java.util.NoSuchElementException;

public class NodeStack implements StackI {


   private Node top;

    class Node {
        public Object data;
        public Node next;
    }


    public NodeStack() {
        this.top = null;
    }

    @Override
    public void push(Object element) {
        if (top==null) {
            Node node = new Node();
            node.data = element;
            top = node;
        } else{
            Node temp = new Node();
            temp.data = element;
            temp.next = top;
            top = temp;
        }
    }

    @Override
    public Object pop() {
//        return top.data = (top.next.data);
        if (top==null){
            throw new NoSuchElementException();
        }
        Object element = top.data;
        top = top.next;
        return element;
    }

    @Override
    public Object peek() {
       if (!isEmpty()){
           return top.data;
       } else
          throw new NoSuchElementException();
    }

    @Override
    public int size() {
        int count = 0;
        Node temp = top;

        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}


