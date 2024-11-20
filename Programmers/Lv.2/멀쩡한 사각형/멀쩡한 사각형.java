import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long total = (long) w * (long) h;
        long blank = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return total - blank;
    }
}
