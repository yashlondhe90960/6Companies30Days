class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        backTrack(s, 0, 0, set);
        return max;
    }
    private void backTrack(String s, int start, int end, Set<String> set){
        if(end+1 == s.length()){
            String temp = s.substring(start, end+1);
            max = Math.max(max, set.contains(temp) ? set.size() : set.size()+1);
            return;
        }
        String temp = s.substring(start, end+1);
        if(!set.contains(temp)){
            set.add(temp);
            backTrack(s, end+1, end+1, set);
            set.remove(temp);
        }
        backTrack(s, start, end+1, set);
    }
}