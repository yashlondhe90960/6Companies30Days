class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors)
    {
        
        int m=students.length;
        boolean[] visited=new boolean[m];
        
        return backtrack(0,students,mentors,visited,m);
        
    }
    
    public int backtrack(int index, int[][] students, int[][] mentors, boolean[] visited,int m)
    {
        if(index==m)
        {
            return 0;
        }
        
        int max=0;
        
        for(int i=0;i<m;i++)
        {
            if(visited[i]==true)
            {
                continue;
            }
            
            visited[i]=true;
            
            int sum=getsum(students[index],mentors[i])+backtrack(index+1,students,mentors,visited,m);
            
            visited[i]=false;
            max=Math.max(sum,max);
        }
        
        return max;
    }
    
    public int getsum(int[] a, int[] b)
    {
        int count=0;
        
        for(int i=0;i<a.length;i++)
        {
            count+=(a[i]==b[i])?1:0;
        }
        
        return count;
    }
    
}