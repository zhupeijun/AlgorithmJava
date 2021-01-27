package library.algorithm;

public class Mint {
    private final int MOD;

    public Mint() {
        this.MOD = 1000_000_007;
    }

    public Mint(int MOD) {
        this.MOD = MOD;
    }

    public long add(long a, long b) { return (((a + b) % MOD + MOD) % MOD);}
    public long sub(long a, long b) { return (((a - b) % MOD + MOD) % MOD); }
    public long mul(long a, long b) { return (((a * b) % MOD + MOD) % MOD); }
    public long div(long a, long b) { return (((a * inv(b)) % MOD + MOD) % MOD); }
    public long inv(long a) { return pow(a, MOD - 2); }
    public long pow(long a, int n) {
        long ret = 1;
        while (n > 0) {
            if ((n & 1) > 0) { ret = mul(ret, a); }
            a = mul(a, a);
            n >>= 1;
        }
        return ret;
    }
}
