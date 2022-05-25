public class PowerSet {
    private int count;
    private int step;
    private String [] slots;

    public PowerSet() {
        count = 0;
        step = 3;
        slots = new String[20000];
    }

    private int hashFun(String key) {
        int sumOfChars = 0;
        for (int i = 0; i < key.length(); i++){
            sumOfChars += key.charAt(i) / 10;
        }
        return sumOfChars % this.slots.length;
    }

    private int seek(String value){
        int slot = hashFun(value);
        int counter = 0;
        while (counter < this.slots.length) {
            if (slot >= this.slots.length) slot = slot - this.slots.length;
            if (this.slots[slot] == null) return slot;
            slot += step;
            counter++;
        }
        return -1;
    }

    private int find(String value){
        int slot = hashFun(value);
        int counter = 0;
        while (counter < this.slots.length) {
            if (slot >= this.slots.length) slot = slot - this.slots.length;
            if (this.slots[slot] != null && this.slots[slot].equals(value)) return slot;
            slot += step;
            counter++;
        }
        return -1;
    }

    public int size() {
        return count;
    }

    public void put(String value) {
        if (!get(value)) {
            slots[this.seek(value)] = value;
            count++;
        }
    }

    public boolean get(String value) {
        return this.find(value) >= 0;
    }

    public boolean remove(String value) {
        if (get(value)) {
            slots[find(value)] = null;
            count--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet newSet = new PowerSet();
        for (String slot : this.slots) {
            if (slot != null && set2.get(slot)) newSet.put(slot);
        }
        return newSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet newSet = new PowerSet();
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) newSet.put(this.slots[i]);
            if (set2.slots[i] != null) newSet.put(set2.slots[i]);
        }
        return newSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet newSet = new PowerSet();
        for (String slot : slots) {
            if (slot != null && !set2.get(slot)) newSet.put(slot);
        }
        return newSet;
    }

    public boolean isSubset(PowerSet set2) {
        for (int i = 0; i < set2.slots.length; i++) {
            if (set2.slots[i] != null && !this.get(set2.slots[i])) return false;
        }
        return true;
    }
}
