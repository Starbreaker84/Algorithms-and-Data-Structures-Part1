public class PowerSet {
    public int count;
    public int step;
    public int size;
    public String [] slots;

    public PowerSet() {
        count = 0;
        step = 7;
        size = 20000;
        slots = new String[size];
    }

    public int hashFun(String key) {
        if (key == "") return 0;
        int sumOfChars = 0;
        for (int i = 0; i < key.length(); i++){
            sumOfChars += key.charAt(i) / 10;
        }
        return sumOfChars % this.size;
    }

    public int size() {
        return count;
    }

    public void put(String value) {
        int slot = this.hashFun(value);
        boolean inDict = this.get(value);
        int counter = 0;
        while (counter < this.size && !inDict){
            if (slot >= this.size) slot = slot - this.size;
            if (this.slots[slot] == null) {
                this.slots[slot] = value;
                this.count++;
                break;
            }
            slot += step;
            counter++;
        }
    }

    public boolean get(String value) {
        int slot = hashFun(value);
        int counter = 0;
        int match = 0;
        while (counter < this.size && match < count){
            if (slot >= this.size) slot = slot - this.size;
            if (this.slots[slot] == value) return true;
            if (this.slots[slot] != value && this.slots[slot] != null) match++;
            slot += step;
            counter++;
        }
        return false;
    }

    public boolean remove(String value) {
        int slot = this.hashFun(value);
        boolean inDict = this.get(value);
        int counter = 0;
        while (counter < this.size && inDict){
            if (slot >= this.size) slot = slot - this.size;
            if (this.slots[slot] == value) {
                this.slots[slot] = null;
                this.count--;
                return true;
            }
            slot += step;
            counter++;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet newSet = new PowerSet();
        int length = this.size();
        if (length > set2.size()) length = set2.size();
        int counter = 0;
        int match = 0;
        while (counter < this.size && match < length) {
            if (this.slots[counter] != null && set2.get(this.slots[counter])) {
                newSet.put(slots[counter]);
                match++;
            }
            counter++;
        }
        return newSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet newSet = new PowerSet();
        int length = this.size();
        int counter = 0;
        int match = 0;
        while (counter < this.size && match < length) {
            if (this.slots[counter] != null) {
                newSet.put(this.slots[counter]);
                match++;
            }
            counter++;
        }

        length = set2.size();
        counter = 0;
        match = 0;
        while (counter < set2.size && match < length) {
            if (set2.slots[counter] != null) {
                newSet.put(set2.slots[counter]);
                match++;
            }
            counter++;
        }
        return newSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet newSet = new PowerSet();
        int length = this.size();
        int counter = 0;
        int match = 0;
        while (counter < this.size && match < length) {
            if (this.slots[counter] != null) match++;
            if (this.slots[counter] != null && !set2.get(this.slots[counter])) {
                newSet.put(slots[counter]);
            }
            counter++;
        }
        return newSet;
    }

    public boolean isSubset(PowerSet set2) {
        if (this.size() < set2.size()) return false;
        int length = set2.size();
        int counter = 0;
        int match = 0;
        while (counter < this.size && match < length) {
            if (set2.slots[counter] != null) match++;
            if (set2.slots[counter] != null && !this.get(set2.slots[counter])) {
                return false;
            }
            counter++;
        }
        return true;
    }
}
