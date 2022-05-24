import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        if (key == "") return 0;
        int sumOfChars = 0;
        for (int i = 0; i < key.length(); i++){
            sumOfChars += key.charAt(i) / 10;
        }
        return sumOfChars % this.size;
    }

    public boolean isKey(String key) {
        int slot = hashFun(key);
        int counter = 0;
        while (counter < this.size){
            if (slot >= this.size) slot = slot - this.size;
            if (slots[slot] == key) return true;
            slot++;
            counter++;
        }
        return false;
    }

    public void put(String key, T value) {
        int slot = this.hashFun(key);
        boolean inDict = this.isKey(key);
        int counter = 0;
        while (counter < this.size){
            if (slot >= this.size) slot = slot - this.size;
            if ((slots[slot] == null && !inDict) || (slots[slot] == key && inDict)){
                this.slots[slot] = key;
                this.values[slot] = (T) value;
                break;
            }
            slot++;
            counter++;
        }
    }

    public T get(String key) {
        int slot = hashFun(key);
        int counter = 0;
        while (counter < this.size){
            if (slot >= this.size) slot = slot - this.size;
            if (this.slots[slot] == key) return this.values[slot];
            slot++;
            counter++;
        }
        return null;
    }
}
