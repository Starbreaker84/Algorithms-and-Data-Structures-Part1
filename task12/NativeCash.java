import java.lang.reflect.Array;

class NativeCash<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public NativeCash(int size, Class clazz){
        this.size = size;
        this.slots = new String[this.size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.hits = new int[this.size];
    }

    private int hashFun(String key) {
        int sumOfChars = 0;
        for (int i = 0; i < key.length(); i++){
            sumOfChars += key.charAt(i) / 10;
        }
        return sumOfChars % this.slots.length;
    }

    private int seek(String key){
        int slot = hashFun(key);
        int counter = 0;
        while (counter < this.slots.length) {
            if (slot >= this.slots.length) slot = slot - this.slots.length;
            if (this.slots[slot] == null) return slot;
            slot += 3;
            counter++;
        }
        return -1;
    }

    private int find(String key){
        int slot = hashFun(key);
        int counter = 0;
        while (counter < this.slots.length) {
            if (slot >= this.slots.length) slot = slot - this.slots.length;
            if (this.slots[slot] != null && this.slots[slot].equals(key)) return slot;
            slot += 3;
            counter++;
        }
        return -1;
    }

    private int minimumHitsSlot(){
        int minHits = -1;
        int slot = 0;
        for (int i = 0; i < this.slots.length; i++){
            if (this.slots[i] != null && minHits == -1) {
                minHits = this.hits[i];
                slot = i;
            }
            if (this.slots[i] != null && minHits > this.hits[i]) {
                minHits = this.hits[i];
                slot = i;
            }
        }
        return slot;
    }

    private void remove(int slot){
        this.slots[slot] = null;
        this.values[slot] = null;
    }

    public T get(String key){
        int slot = find(key);
        if ( slot >= 0) {
            this.hits[slot]++;
            return this.values[slot];
        }
        return null;
    }

    public void put(String key, T value){
        int slot = this.find(key);
        if (slot >= 0) {
            this.values[slot] = value;
        }
        int freeSlot = this.seek(key);
        if (slot < 0 && freeSlot >= 0) {
            this.slots[freeSlot] = key;
            this.values[freeSlot] = value;
            this.hits[freeSlot] = 0;
        }
        if (slot < 0 && freeSlot < 0) {
            this.remove(this.minimumHitsSlot());
            freeSlot = this.seek(key);
            this.slots[freeSlot] = key;
            this.values[freeSlot] = value;
            this.hits[freeSlot] = 0;
        }
    }

    public boolean isKey(String key){
        return this.find(key) >= 0;
    }
}
