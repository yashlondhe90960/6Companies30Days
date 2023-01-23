class Solution {
    public int distinctEchoSubstrings(String text) {
        int ans = 0, n = text.length()/2;
        for (int i = 1; i <= n; i++){ // i = length
            Set<String> seen = new HashSet<>();
            for (int j = 0, k = j+i, ok = 0; k < text.length(); j++, k++){ // j = start of 1st part, k = start of 2nd part.
                if (text.charAt(j) == text.charAt(k)){ // matched
                    ok++;
                }
                if (j >= i && text.charAt(j-i) == text.charAt(k-i)){ // was matched, but out of bound now, so delete 1
                    ok--;
                }
                if (j >= i-1 && ok == i && seen.add(text.substring(j-i+1,j+1))){ // if it echoes and we've not seen it, add 1 to ans
                    ans++;
                }
            }
        }
        return ans;
    }
}