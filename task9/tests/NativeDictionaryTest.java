import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {
    @Test
    void isKey_true(){
        NativeDictionary dict = new NativeDictionary(19, Integer.class);
        dict.slots[10] = "Magenta";
        dict.values[10] = 255_000_255;
        assertTrue(dict.isKey("Magenta"));
    }

    @Test
    void isKey_false(){
        NativeDictionary dict = new NativeDictionary(19, Integer.class);
        dict.slots[10] = "Magenta";
        dict.values[10] = 255_000_255;
        assertFalse(dict.isKey("Yellow"));
    }

    @Test
    void put(){
        NativeDictionary dict = new NativeDictionary(19, Integer.class);
        dict.slots[10] = "Black";
        dict.values[10] = 0;
        dict.put("Magenta", 255_000_255);
        assertEquals("Magenta", dict.slots[11]);
        assertEquals(255_000_255, dict.values[11]);
        dict.put("Magenta", 255_0_255);
        assertEquals("Magenta", dict.slots[11]);
        assertEquals(255_0_255, dict.values[11]);
    }

    @Test
    void get_null(){
        NativeDictionary dict = new NativeDictionary(5, Integer.class);
        assertNull(dict.get("Yellow"));
        assertNull(dict.get("Black"));
    }

    @Test
    void get(){
        NativeDictionary dict = new NativeDictionary(3, Integer.class);
        dict.put("Magenta", 255_0_255);
        dict.put("Yellow", 255_255_000);
        dict.put("Cian", 000_255_255);
        assertEquals(255_255_000, dict.get("Yellow"));
        assertNull(dict.get("Black"));
    }

    @Test
    void regression(){
        NativeDictionary dict = new NativeDictionary(19, Integer.class);
        dict.put("Magenta", 255_000_255);
        dict.put("Yellow", 255_255_000);
        dict.put("Cian", 000_255_255);

        assertTrue(dict.isKey("Magenta"));
        assertTrue(dict.isKey("Yellow"));
        assertTrue(dict.isKey("Cian"));
        assertFalse(dict.isKey("Black"));

        assertEquals(255_000_255, dict.get("Magenta"));
        assertEquals(255_255_000, dict.get("Yellow"));
        assertEquals(000_255_255, dict.get("Cian"));

        dict.put("Magenta", 255_0_255);
        dict.put("Yellow", 255_255_0);

        assertEquals(255_0_255, dict.get("Magenta"));
        assertEquals(255_255_0, dict.get("Yellow"));
        assertEquals(000_255_255, dict.get("Cian"));
    }
}
