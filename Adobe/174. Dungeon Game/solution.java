class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MIN_VALUE));
        int val = f(dungeon, dp, 0, 0);
        if(val >=0) return 1;
        return Math.abs(val) +1;


    }

    private int f(int[][] dungeon, int[][] dp, int row, int col){
        if(row == dungeon.length -1 && col == dungeon[0].length -1){
            return dungeon[row][col] > 0 ? 0 : dungeon[row][col];
        }

        if(dp[row][col] != Integer.MIN_VALUE) return dp[row][col];

        //rightward
        int right = Integer.MIN_VALUE;
        if(col < dungeon[0].length-1) right = f(dungeon, dp, row, col+1) + dungeon[row][col];

        //downward
        int down = Integer.MIN_VALUE;
        if(row < dungeon.length-1) down = f(dungeon, dp, row+1, col) + dungeon[row][col];

        int max = Math.max(right, down);

        return dp[row][col] = max > 0 ? 0 : max;
    }


}