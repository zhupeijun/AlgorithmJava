package library.algorithm;

import java.util.function.IntSupplier;

public class Mint {
    private final static int DEFAULT = 1000_000_007;
    private IntSupplier modVal = () -> DEFAULT;

    public Mint() {
    }

    public Mint(int value) {
        this.modVal = () -> value;
    }
    
    public Mint(IntSupplier modVal) {
        this.modVal = modVal;
    }

    public long add(long a, long b) { return (((a + b) % mod() + mod()) % mod());}
    public long sub(long a, long b) { return (((a - b) % mod() + mod()) % mod()); }
    public long mul(long a, long b) { return (((a * b) % mod() + mod()) % mod()); }
    public long div(long a, long b) { return (((a * inv(b)) % mod() + mod()) % mod()); }
    public long inv(long a) { return pow(a, mod() - 2); }
    public long pow(long a, int n) {
        long ret = 1;
        while (n > 0) {
            if ((n & 1) > 0) { ret = mul(ret, a); }
            a = mul(a, a);
            n >>= 1;
        }
        return ret;
    }
    
    private int mod() {
        return modVal.getAsInt();
    }
}
