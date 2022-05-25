public class BloomFilter {
    public int filter_len;
    int bitArray = 0;

    public BloomFilter(int f_len) {
        filter_len = f_len;
    }

    public int hash1(String str1) {
        // 17
        int result = 0;
        for(int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = (result * 17 + code) % filter_len;
        }
        return result;
    }
    public int hash2(String str1) {
        int result = 0;
        for(int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = (result * 223 + code) % filter_len;
        }
        return result;
    }

    public void add(String str1) {
        int index1 = hash1(str1);
        int index2 = hash2(str1);
        this.bitArray |= (int) Math.pow(2, index1);
        this.bitArray |= (int) Math.pow(2, index2);
    }

    public boolean isValue(String str1) {
        int index1 = hash1(str1);
        int index2 = hash2(str1);
        int mask1 = (int) Math.pow(2, index1);
        int mask2 = (int) Math.pow(2, index2);
        return (((this.bitArray & mask1) != 0) && ((this.bitArray & mask2) != 0));
    }
}
