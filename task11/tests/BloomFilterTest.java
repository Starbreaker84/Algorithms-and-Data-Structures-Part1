import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {
    @Test
    void filter(){
        BloomFilter filter = new BloomFilter(32);
        filter.add("0123456789");
        filter.add("4567890123");
        assertFalse(filter.isValue("9012345678"));
        assertTrue(filter.isValue("4567890123"));
    }

    @Test
    void filter_complete(){
        BloomFilter filter = new BloomFilter(32);
        filter.add("0123456789");
        filter.add("8452168998");
        filter.add("8562145893");
        filter.add("8412534568");
        filter.add("8452153695");
        assertFalse(filter.isValue("9012345678"));
    }
}
