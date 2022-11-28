package bstmap;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class BSTMap<K extends Comparable<K>, V > implements Map61B<K, V> {

    private BSTNode root;
    //private int size = 0;
    private class BSTNode{
        private K key;
        private V val;

        private BSTNode left, right;
        private int size;

        public BSTNode(K key, V val, int size) {
            this.key = key;
            this.val= val;
            this.size = size;

        }
    }
    public BSTMap() {

    }
    public void put(K key, V val) {
        if (key == null)
            return;
        //if (val == null)
        //    key = null;
        root = put(root, key, val);
    }
    private BSTNode put(BSTNode root, K key, V val){
        if (root == null) {
            return new BSTNode(key, val, 1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, val);
        }
        if (cmp > 0) {
            root.right = put(root.right, key, val);
        } else {
            root.val = val;
        }
        root.size =  1 + size(root.left) + size(root.right);
        return root;
    }
    public int size() {
        return size(root);
    }
    public int size(BSTNode x) {
        if (x == null) return 0;
        else return x.size;
    }
    public V get(K key) {
        return get(root, key);
    }
    private V get(BSTNode x, K key) {
        if (key == null) return null;
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }
    public boolean containsKey(K key) {
        return containsKey(root, key);

    }
    private boolean containsKey(BSTNode x, K key) {
        if (key == null)
            return false;
        if (x == null) return false;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return containsKey(x.left, key);
        } else if (cmp > 0) {
            return containsKey(x.right, key);
        } else {
            return true;
        }
    }
    public void clear () {
            root = null;
            size();
        }

    public void printInOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.println(root.key);
        printInOrder(root.right);
    }
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        addKeys(root, set);
        return set;
    }
    private void addKeys(BSTNode x, Set<K> set) {
        if(x == null) return;
        set.add(x.key);
        addKeys(x.left, set);
        addKeys(x.right, set);
    }
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    public V remove(K key, V val) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
