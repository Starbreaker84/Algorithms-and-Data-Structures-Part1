import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void seekSlot_normal(){
        HashTable hashTable = new HashTable(19, 3);
        assertEquals(10, hashTable.seekSlot("Magenta"));
    }

    @Test
    void seekSlot_with_one_collision(){
        HashTable hashTable = new HashTable(19, 3);
        hashTable.slots[10] = "Magenta";
        assertEquals(13, hashTable.seekSlot("Magenta"));
    }

    @Test
    void seekSlot_with_overdrive_collision(){
        HashTable hashTable = new HashTable(19, 3);
        hashTable.slots[10] = "Magenta";
        hashTable.slots[13] = "Magenta";
        hashTable.slots[16] = "Magenta";
        assertEquals(0, hashTable.seekSlot("Magenta"));
    }

    @Test
    void seekSlot_no_slots(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            hashTable.slots[i] = "Magenta";
        }
        assertEquals(-1, hashTable.seekSlot("Magenta"));
    }

    @Test
    void seekSlot_one_slot_free(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            if (i != 5) hashTable.slots[i] = "Magenta";
        }
        assertEquals(5, hashTable.seekSlot("Magenta"));
    }

    @Test
    void put_normal(){
        HashTable hashTable = new HashTable(19, 3);
        assertEquals(10, hashTable.put("Magenta"));
    }

    @Test
    void put_with_collisions(){
        HashTable hashTable = new HashTable(19, 3);
        hashTable.put("Magenta");
        hashTable.put("Magenta");
        assertEquals(16, hashTable.put("Magenta"));
    }

    @Test
    void put_with_overdrive_collisions(){
        HashTable hashTable = new HashTable(19, 3);
        hashTable.put("Magenta");
        hashTable.put("Magenta");
        hashTable.put("Magenta");
        assertEquals(0, hashTable.put("Magenta"));
    }

    @Test
    void put_no_slots(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            hashTable.slots[i] = "Magenta";
        }
        assertEquals(-1, hashTable.put("Magenta"));
    }

    @Test
    void put_one_slot_free(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            if (i != 7) hashTable.slots[i] = "Magenta";
        }
        assertEquals(7, hashTable.put("Magenta"));
    }

    @Test
    void find_normal(){
        HashTable hashTable = new HashTable(19, 3);
        hashTable.put("Magenta");
        assertEquals(10, hashTable.find("Magenta"));
    }
    @Test
    void find_with_collisions(){
        HashTable hashTable = new HashTable(19, 3);
        hashTable.put("Magenta");
        hashTable.put("Cian");
        int slot = hashTable.put("Yellow");
        hashTable.put("Red");
        hashTable.put("Black");
        hashTable.put("Velvet");
        assertEquals(slot, hashTable.find("Yellow"));
    }



}
