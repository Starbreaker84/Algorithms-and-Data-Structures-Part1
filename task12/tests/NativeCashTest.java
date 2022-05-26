import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NativeCashTest {

    @Test
    void put(){
        NativeCash cash = new NativeCash<>(5, Integer.class);
        cash.put("One", 1);
        cash.put("Two", 2);
        cash.put("Tree", 3);
        cash.put("Four", 4);
        assertEquals(1, cash.get("One"));
        assertEquals(2, cash.get("Two"));
        assertEquals(3, cash.get("Tree"));
        assertEquals(4, cash.get("Four"));
        assertNull(cash.get("Five"));
    }

    @Test
    void put_already(){
        NativeCash cash = new NativeCash<>(5, Integer.class);
        cash.put("One", 1);
        cash.put("Two", 2);
        cash.put("Tree", 3);
        cash.put("Four", 4);
        cash.put("Five", 5);
        cash.put("Tree", 33);
        assertEquals(1, cash.get("One"));
        assertEquals(2, cash.get("Two"));
        assertEquals(33, cash.get("Tree"));
        assertEquals(4, cash.get("Four"));
        assertEquals(5, cash.get("Five"));
    }

    @Test
    void put_remove(){
        NativeCash cash = new NativeCash<>(5, Integer.class);
        cash.put("One", 1);
        cash.put("Two", 2);
        cash.put("Tree", 3);
        cash.put("Four", 4);
        cash.put("Five", 5);
        cash.get("One");
        cash.get("One");
        cash.get("One");
        cash.get("Two");
        cash.get("Two");
        cash.get("Tree");
        cash.get("Four");
        cash.get("Four");
        cash.get("Four");
        cash.get("Five");
        cash.get("Five");
        cash.get("Five");

        cash.put("Six", 6);
        assertNull(cash.get("Tree"));
        assertEquals(6, cash.get("Six"));
    }
}
