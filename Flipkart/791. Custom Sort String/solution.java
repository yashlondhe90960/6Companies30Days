class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = new char[26];
        for(char c : s.toCharArray()){
            ch[c - 'a'] += 1;
        }
        for(char c : order.toCharArray()){
            if(ch[c - 'a'] > 0){
                while(ch[c - 'a'] > 0){
                    sb.append(c);
                    ch[c - 'a']--;
                }
            }
        }
        for(int i = 0; i < 26; i++){
            if(ch[i] > 0){
                while(ch[i] > 0){
                    sb.append((char)(i + 'a'));
                    ch[i]--;
                }
            }
        }
        return sb.toString();
    }
}