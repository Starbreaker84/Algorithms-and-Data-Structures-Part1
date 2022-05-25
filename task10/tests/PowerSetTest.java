import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {
    @Test
    void get_false(){
        PowerSet set = new PowerSet();
        set.slots[18] = "DAA";
        set.slots[25] = "AAD";
        set.count = 2;
        assertFalse(set.get("ADA"));
    }

    @Test
    void get_true(){
        PowerSet set = new PowerSet();
        set.slots[18] = "DAA";
        set.slots[25] = "AAD";
        set.slots[32] = "ADA";
        set.count = 3;
        assertTrue(set.get("ADA"));
    }

    @Test
    void put(){
        PowerSet set = new PowerSet();
        set.put("John");
        set.put("ADA");
        set.put("Mole");
        assertEquals(3, set.size());
        set.put("John");
        assertEquals(3, set.size());
    }

    @Test
    void remove(){
        PowerSet set = new PowerSet();
        set.put("John");
        set.put("ADA");
        set.put("Mole");
        assertEquals(3, set.size());
        assertTrue(set.remove("ADA"));
        assertTrue(set.remove("John"));
        assertFalse(set.remove("ADA"));
        assertTrue(set.remove("Mole"));
        assertEquals(0, set.size());
    }

    @Test
    void remove_empty(){
        PowerSet set = new PowerSet();
        assertFalse(set.remove("ADA"));
        assertEquals(0, set.size());
    }

    @Test
    void intersection(){
        PowerSet set1 = new PowerSet();
        set1.put("John");
        set1.put("ADA");
        set1.put("Mole");
        set1.put("Barry");
        set1.put("Jill");
        PowerSet set2 = new PowerSet();
        set2.put("Chris");
        set2.put("ADA");
        set2.put("Walker");
        set2.put("Barry");
        set2.put("Jill");
        PowerSet set3 = set1.intersection(set2);
        assertEquals(3, set3.size());
        assertTrue(set3.get("Barry"));
        assertTrue(set3.get("ADA"));
        assertTrue(set3.get("Jill"));
        assertFalse(set3.get("John"));
        assertFalse(set3.get("Chris"));
        assertFalse(set3.get("Walker"));
        assertFalse(set3.get("Mole"));
    }

    @Test
    void intersection_empty(){
        PowerSet set1 = new PowerSet();
        set1.put("John");
        set1.put("ADA");
        set1.put("Mole");
        set1.put("Barry");
        set1.put("Jill");
        PowerSet set2 = new PowerSet();
        set2.put("Chris");
        set2.put("Walker");
        PowerSet set3 = set1.intersection(set2);
        assertEquals(0, set3.size());
        assertFalse(set3.get("Barry"));
        assertFalse(set3.get("ADA"));
        assertFalse(set3.get("Jill"));
        assertFalse(set3.get("John"));
        assertFalse(set3.get("Chris"));
        assertFalse(set3.get("Walker"));
        assertFalse(set3.get("Mole"));
    }

    @Test
    void union(){
        PowerSet set1 = new PowerSet();
        set1.put("John");
        set1.put("ADA");
        set1.put("Mole");
        set1.put("Barry");
        set1.put("Chris");
        set1.put("Jill");
        PowerSet set2 = new PowerSet();
        set2.put("Chris");
        set2.put("Walker");
        set1.put("Barry");

        PowerSet set3 = set1.union(set2);
        assertEquals(7, set3.size());
        assertTrue(set3.get("Barry"));
        assertTrue(set3.get("ADA"));
        assertTrue(set3.get("Jill"));
        assertTrue(set3.get("John"));
        assertTrue(set3.get("Chris"));
        assertTrue(set3.get("Walker"));
        assertTrue(set3.get("Mole"));
    }

    @Test
    void union_firstEmpty(){
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        set2.put("Chris");
        set2.put("Walker");

        PowerSet set3 = set1.union(set2);
        assertEquals(2, set3.size());
        assertFalse(set3.get("John"));
        assertFalse(set3.get("ADA"));
        assertFalse(set3.get("Mole"));
        assertTrue(set3.get("Chris"));
        assertTrue(set3.get("Walker"));
    }

    @Test
    void difference(){
        PowerSet set1 = new PowerSet();
        set1.put("Chris");
        set1.put("Tyrant");
        set1.put("Barry");
        PowerSet set2 = new PowerSet();
        set2.put("Barry");
        set2.put("John");
        set2.put("ADA");
        set2.put("Mole");
        set2.put("Barry");
        set2.put("Chris");
        set2.put("Jill");

        PowerSet set3 = set1.difference(set2);
        assertEquals(1, set3.size());
        assertTrue(set3.get("Tyrant"));
    }

    @Test
    void difference_empty(){
        PowerSet set1 = new PowerSet();
        set1.put("Chris");
        set1.put("John");
        set1.put("Barry");
        PowerSet set2 = new PowerSet();
        set2.put("Barry");
        set2.put("John");
        set2.put("ADA");
        set2.put("Mole");
        set2.put("Barry");
        set2.put("Chris");
        set2.put("Jill");

        PowerSet set3 = set1.difference(set2);
        assertEquals(0, set3.size());
    }

    @Test
    void isSubset_falseBySize(){
        PowerSet set1 = new PowerSet();
        set1.put("Chris");
        set1.put("John");
        set1.put("Barry");
        PowerSet set2 = new PowerSet();
        set2.put("Barry");
        set2.put("John");
        set2.put("ADA");
        set2.put("Mole");
        set2.put("Barry");
        set2.put("Chris");
        set2.put("Jill");
        assertFalse(set1.isSubset(set2));
    }

    @Test
    void isSubset_falseByValues(){
        PowerSet set1 = new PowerSet();
        set1.put("Chris");
        set1.put("John");
        set1.put("Barry");
        PowerSet set2 = new PowerSet();
        set2.put("Barry");
        set2.put("Chris");
        set2.put("Jill");
        assertFalse(set1.isSubset(set2));
    }

    @Test
    void isSubset_true(){
        PowerSet set1 = new PowerSet();
        set1.put("Chris");
        set1.put("Jill");
        set1.put("Barry");
        set1.put("Mole");
        set1.put("ADA");
        PowerSet set2 = new PowerSet();
        set2.put("Barry");
        set2.put("Chris");
        set2.put("Jill");
        assertTrue(set1.isSubset(set2));
    }
}
