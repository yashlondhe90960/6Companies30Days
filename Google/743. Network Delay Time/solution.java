class Solution {
    public int networkDelayTime(int[][] times, int V, int k) {
        List<List<Integer>>[] adj = new ArrayList[V+1];
        for(int i=0;i<=V;i++) adj[i] = new ArrayList<>();
        for(int i=0;i<times.length;i++){
            adj[times[i][0]].add(Arrays.asList(times[i][1],times[i][2]));
        }
        int ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]));
		int dist[] = new int[V+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		pq.add(new int[]{0,k});
		dist[k] = 0;
		while(!pq.isEmpty()){
			int temp[] = pq.remove();
			if(dist[temp[1]] < temp[0]) continue;
			for(List<Integer> e : adj[temp[1]]){
				int nbr = e.get(0);
				int wt = e.get(1);
				if(temp[0] + wt < dist[nbr]){
					dist[nbr] = temp[0] + wt;
					pq.add(new int[]{dist[nbr],nbr});
				}
			}
		}
		for(int i=1;i<=V;i++){
			if(dist[i] == Integer.MAX_VALUE) return -1;
			ans = Math.max(ans,dist[i]);
		}
		return ans;
    }
}