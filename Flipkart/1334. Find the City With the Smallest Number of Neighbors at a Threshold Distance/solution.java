class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat=new int[n][n];
        for(int i=0;i<edges.length;i++){
            mat[edges[i][0]][edges[i][1]]=edges[i][2];
            mat[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)mat[i][j]=10000001;
                if(i==j)mat[i][j]=0;
            }
        }
        for(int node=0;node<n;node++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=Math.min(mat[i][j],mat[i][node]+mat[node][j]);
                }
            }
        }
        int ans=0,min=1000;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]<=distanceThreshold)count++;
            }
            if(count<=min){min=count;ans=i;}
        }
        return ans;
    }
}