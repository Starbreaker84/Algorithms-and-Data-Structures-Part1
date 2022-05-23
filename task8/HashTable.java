public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        if (value == "") return 0;
        int sumOfChars = 0;
        for (int i = 0; i < value.length(); i++){
            sumOfChars += (int) value.charAt(i) / 10;
        }
        return sumOfChars % this.size;
    }

    public int seekSlot(String value) {
        int slot = hashFun(value);
        if (this.slots[slot] == null) return slot;
        int counter = 0;
        while (counter < this.size - 1){
            slot += this.step;
            if (slot >= this.size) slot = slot - this.size;
            if (slots[slot] == null) return slot;
            counter++;
        }
        return -1;
    }

    public int put(String value) {
        int slot = hashFun(value);
        if (this.slots[slot] == null) {
            this.slots[slot] = value;
            return slot;
        }
        int counter = 0;
        while (counter < this.size - 1){
            slot += this.step;
            if (slot >= this.size) slot = slot - this.size;
            if (slots[slot] == null) {
                this.slots[slot] = value;
                return slot;
            }
            counter++;
        }
        return -1;
    }

    public int find(String value) {
        int slot = hashFun(value);
        if (this.slots[slot] == value) return slot;
        int counter = 0;
        while (counter < this.size - 1){
            slot += this.step;
            if (slot >= this.size) slot = slot - this.size;
            if (slots[slot] == value) return slot;
            counter++;
        }
        return -1;
    }
}
