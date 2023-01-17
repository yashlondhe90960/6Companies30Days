class Solution {
    public int numberOfCombinations(String num) {
        int n = num.length();
        // cont[i][j] = number of combinations (mod 1e9+7) in substring(num,i,n) starting with numbers (chunsk) at least j digits
        // so final answer is cont[0][1]
        int[][] cont = new int[n+1][n+1];
        for (int i = n-1; i >= 0; i--) {
            if (num.charAt(i) == '0') continue;
            // check once if there is a long sequence of same characters
            int e = i;
            while (e < n && num.charAt(e) == num.charAt(i))
                e++;
            int t = 1;
            cont[i][n-i] = t;
            for (int j = n-i-1; j > 0; j--) {
                if (i+j+j>n) {
                    cont[i][j] = t;
                    continue;
                }
                int l;
                if (i+j+j <= e) {
                    // no need to check if next substring of j digits is bigger if we are within the pre-checked substring
                    l = j;
                } else {
                    l = 0;
                    while (l < j && num.charAt(i+l) == num.charAt(i+j+l))
                        l++;
                }
                // pick continuation of j or j+1 digits
                if (l == j || num.charAt(i+l) < num.charAt(i+j+l)) {
                    t = (t + cont[i+j][j]) % 1000000007;
                } else if (j < n) {
                    t = (t + cont[i+j][j+1]) % 1000000007;
                }
                cont[i][j] = t;
            }
        }
        return cont[0][1];
    }
}