class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res=Integer.MIN_VALUE;
        for(int i=0;i<special.length;i++){
            res = Math.max( res, special[i]-bottom );
            bottom = special[i]+1;
        }
        res = Math.max( res,top-special[special.length-1] );

        return res;
    }
}