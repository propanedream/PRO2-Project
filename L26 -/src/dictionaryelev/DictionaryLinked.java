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
		return null;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		// TODO
		if (size==0){
			Node node = new Node();
			node.next = start;
			start.key = key;
			start.value = value;

		} else{
			while (start.next!=null){
				if (key == start.key){
					start.key = key;
					start.value = value;

				} else {
					start.next = start;
				}
			}
		}
		return start.value;
	}

	@Override
	public V remove(K key) {
		// TODO
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
