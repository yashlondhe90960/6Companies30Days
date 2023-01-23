class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            int countZero = 0;
            
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < n; j++) {
                            
                if(nums[j] % p == 0) {
                    countZero++;
                }
                if(countZero > k) break;   
                sb.append(nums[j] + "_");
            
                set.add(sb.toString());
      
            }
          }
        return set.size();
    }
}