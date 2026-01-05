class Solution {
    public boolean hasAlternatingBits(int n) {

        int old = n % 2;  
        n /= 2;

        while (n > 0) {
            int curr = n % 2;

            if (old == curr)
                return false;

            old = curr;
            n /= 2;
        }
        return true;
    }
}
