public int[] rearrangeBarcodes(int[] barcodes) {
    Map<Integer,Integer> mp = new HashMap<>();
    for(var b:barcodes){
        mp.put(b,mp.getOrDefault(b,0) + 1);
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
    for(var ent:mp.entrySet()){
        pq.add(new int[]{ent.getKey(),ent.getValue()});
    }
    int ans[] = new int[barcodes.length];
    int itr = 0;
    int block[] = pq.poll();
    ans[itr++] = block[0];
    --block[1];
    for(;!pq.isEmpty();){
        int free[] = pq.poll();
        ans[itr++] = free[0];
        --free[1];
        if(block[1] > 0)pq.add(block);
        block = free;
    }
    return ans;
}