class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        var map = new HashMap<String, Data>();
        long maxViewCount = 0;
        for (int i=0; i<views.length; i++) {
            var data = map.getOrDefault(creators[i], new Data());
            maxViewCount = Math.max(data.add(ids[i], views[i]), maxViewCount);
            map.putIfAbsent(creators[i], data);
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        for (var entry : map.entrySet()) {
            if (entry.getValue().totalViewCount == maxViewCount) {
                result.add(List.of(entry.getKey(), entry.getValue().videoId));
            }
        }
        return result;
    }
}

class Data {
    String videoId;
    long totalViewCount;
    int singleMax;
    
    public Data() {
        totalViewCount =  0;
        singleMax = 0;
        videoId = null;
    }
    
    public long add(String id, int viewCount) {
        if (singleMax < viewCount) {
            singleMax = viewCount;
            videoId = id;
        } else if (singleMax == viewCount && (videoId == null || videoId.compareTo(id) > 0)) {
            videoId = id;
        }
        totalViewCount += viewCount;
        return totalViewCount;
    }
}