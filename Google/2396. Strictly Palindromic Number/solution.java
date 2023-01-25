class Solution {
    public boolean isStrictlyPalindromic(int n) {
        if(n<2)
        return true;
        for(int base=2;base<= n-2;base++){
            String s = Integer.toString(n,base);
            if(!isPalindrome(s))
            return false;
        }
        return true;

    }
    private boolean isPalindrome(String s){
        int left=0, right=s.length()-1;
        while(left < right){
            if(s.charAt(left++)!=s.charAt(right--))
            return false;

        }
        return true;
        
    }
}