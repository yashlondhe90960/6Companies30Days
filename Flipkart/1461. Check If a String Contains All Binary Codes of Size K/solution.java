class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()-k+1;i++){
            set.add(s.substring(i,i+k));

        }
        for(int i=0;i<(1 << k); i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<k;j++){
                if((i & (1 <<j ))>0){
                    sb.append("1");

                } else {
                    sb.append("0");

                }
            }
            if(!set.contains(sb.toString())){
                return false;
            }
        }
        return true;
        
    }
}