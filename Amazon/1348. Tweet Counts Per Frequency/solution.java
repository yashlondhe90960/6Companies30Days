class TweetCounts {

    //Map of tweetName and list of timing when that tweet recorded over time series.
    Map<String, List<Integer>> map;
    
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    // Simply add time to the value of the tweetName.
    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, list -> new ArrayList<>()).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        
        //Get list of times when particular tweet recorded.
        List<Integer> tweetsTimes = map.get(tweetName);
        
        int windownSize = getWindownSize(freq);
        int size = (endTime-startTime)/windownSize;
        
        int[] timeIntervals = new int[size+1];
        
        for(int tweetsTime: tweetsTimes){
            //If and only if tweetTiem is valid for the given request context
            if(tweetsTime>=startTime && tweetsTime<=endTime){
                timeIntervals[(tweetsTime-startTime)/windownSize]++; 
            }
        }
        for(int timeInterval: timeIntervals){
            result.add(timeInterval);
        }
        return result;
    }
    
    //Get the conversion to number.
    private int getWindownSize(String freq){
        if("minute".equals(freq)){
            return 60;
        }else if("hour".equals(freq)){
            return 60*60;
        }else{
            return 60*60*24;
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */