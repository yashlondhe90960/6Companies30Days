class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
		if(n<2) return n;
		int result = 2;
		for(int i=0;i<n;i++){
			Map<String, Integer> slopeMap = new HashMap();
			int samep = 0;
			for(int j=0;j<n;j++){
				if(i==j) continue;
				int y = points[j][1] - points[i][1];
				int x = points[j][0] - points[i][0];
				if(x==0 && y==0) samep++;
				int gcd = gcd(x,y);
                String slopeKey = (x/gcd)+"_"+(y/gcd);
                slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey,1)+1); 
            }
            result = Math.max(result, Collections.max(slopeMap.values()));
            }
        return result;	
	}

   // return the most common divisor of m and n using Euclidean algorithm
    public int gcd(int m, int n){
        if(n == 0) return m;
        return gcd(n, m % n);
    }
}