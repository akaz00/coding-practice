import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. 
 * 
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 *
 * @See https://oj.leetcode.com/problems/lru-cache/
 */
public class LRUCache {
	static class Node {
		Node next;
		Node prev;
		int key;
		int val;

		Node() {
		}

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}

		private void remove() {
			prev.next = next;
			if (next != null) {
				next.prev = prev;
			}
		}

		private void addAfter(Node node) {
			next = node.next;
			if (next != null) {
				next.prev = this;
			}
			node.next = this;
			prev = node;
		}
	}

	Node head = new Node();
	Node tail = head;

	Map<Integer, Node> cache = new HashMap<Integer, Node>();
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Node n = cache.get(key);
		if (n == null) {
			return -1;
		}
		moveToTail(n);
		return n.val;
	}

	public void set(int key, int value) {
		Node n = cache.get(key);
		if (n != null) {
			n.val = value;
			moveToTail(n);
			return;
		}

		n = new Node(key, value);
		cache.put(key, n);
		addToTail(n);

		if (cache.size() > capacity) {
			n = head.next;
			cache.remove(n.key);
			n.remove();
		}
	}

	private void moveToTail(Node n) {
		if (n == tail)
			return;
		n.remove();
		addToTail(n);
	}

	private void addToTail(Node n) {
		n.addAfter(tail);
		tail = n;
	}

	public static void main(String[] args) throws Exception {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2, 2);
		System.out.println(cache.get(2));
		// assert 2 == cache.get(2);
		cache.set(1, 1);
		cache.set(4, 1);
		System.out.println(cache.get(2));
		// assert -1 == cache.get(2);

		cache = new LRUCache(2);
		System.out.println(cache.get(2));
		cache.set(2, 6);
		System.out.println(cache.get(1));
		cache.set(1, 5);
		cache.set(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));

		cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		System.out.println(cache.get(2));
		cache.set(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
}