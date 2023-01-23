import java.util.Arrays;
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int answer = 0;
        int Length = piles.length;
        int[] temp = new int[Length/3];

        for(int i = Length-2; i > (Length/3)-1;i-=2){
            answer += piles[i];
        }


        return answer;
    }
}