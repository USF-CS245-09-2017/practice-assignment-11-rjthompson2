import java.lang.*;
public class Hashtable{
    HashNode[] buckets;
    int max;
    int size;

    public Hashtable(){
        max = 1000000;
        buckets = new HashNode[max];
        size = 0;
    }

    class HashNode{
        public String key;
        public String value;
        public HashNode next;
        public HashNode(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
            size = 0;
        }
    }

    boolean containsKey(String key){
        int index = getIndex(key);
        HashNode node = buckets[index];
        while(node != null){
            if(node.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    String get(String key){
        int index = getIndex(key);
        HashNode node = buckets[index];
        while(node != null) {
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public int getIndex(String key){
        int hash = key.hashCode();
        return Math.abs((hash % max));
    }

    void put(String key, String value){
        int index = getIndex(key);
        HashNode node = buckets[index];
        while(node != null){
            if(node.key.equals(key)){
                node.key = key;
                node.value = value;
                return;
            }
            node = node.next;
        }
        size++;
        HashNode temp = new HashNode(key, value);
        temp.next = buckets[index];
        buckets[index] = temp;
    }

    String remove(String key){
        int index = getIndex(key);
        HashNode temp = buckets[index];
        HashNode previous = null;
        while(temp.next != null && !temp.key.equals(key)){
            previous = temp;
            temp = temp.next;
        }
        if(temp.key.equals(key)){
            if (temp == null){
                return null;
            }
        }
        if(previous == null){
            buckets[index] = temp.next;
        }
        else{
            previous.next = temp.next;
            size--;
        }
        return temp.value;
    }
}
