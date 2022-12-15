package dictionaryelev;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

    private Node start;
    private int size;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryLinked() {
        // Sentinel (tomt listehoved - der ikke indeholder data)
        start = new Node();
        size = 0;
    }

    @Override
    public V get(K key) {
        // TODO
        Node current = start;
        V value = null;
        do {
            if (current.next.key == key) {
                return current.next.value;
            } else {
                current = current.next;
            }
        }
        while (current.next != null);
        return value;


    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        // TODO
//        if (size == 0) {
//            Node node = new Node();
//            node.next = start;
//            start.key = key;
//            start.value = value;
//
//        } else {
//            while (start.next != null) {
//                if (key == start.key) {
//                    start.key = key;
//                    start.value = value;
//
//                } else {
//                    start.next = start;
//                }
//            }
//        }
//        return start.value;
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        Node current = start;
        V preValue = null;

        while (current.next != null) {
            if (current.next.key == key) {
                preValue = current.next.value;
                current.next.value = value;

            }
            current = current.next;
        }
        if (preValue == null){
            current.next = newNode;
            size++;
        }
        return preValue;
    }

    @Override
    public V remove(K key) {
        // TODO
        V value = null;
        Node current = start.next;
        Node previous = start;
        boolean found = false;

        while (current!=null&&!found){
            if (current.key.equals(key)){
                found=true;

            }
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }

    private class Node {
        Node next;
        K key;
        V value;
    }

}
