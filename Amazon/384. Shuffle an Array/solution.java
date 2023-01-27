class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        
        this.nums = nums;
        random  = new Random();

        
    }
    
    public int[] reset() {
        return nums;
        
    }
    
    public int[] shuffle() {
        int[] shuffled = nums.clone();
        for(int i=0;i<shuffled.length;i++){
            int randIndex = random.nextInt(shuffled.length-i)+i;
            int temp = shuffled[i];
            shuffled[i] = shuffled[randIndex];
            shuffled[randIndex] = temp;

        }
        return shuffled;
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */