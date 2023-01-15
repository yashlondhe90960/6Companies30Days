// Here we are taking a map which is storing an array corresponding to trimi, i.e. query[1]
// The array is of type node that contains index and val(substring of each element of queries len-auery[i],len)
// after this we sort the array based on val and find out the index corresponding to val
// 1->[(0,2),(1,3),(2,1),(3,4)](unsorted) -> [(2,1),(0,2),(1,3),(3,4)]
// 3->[(0,102),(2,251),(3,473),(4,814)]
// 2->[(0,02),(3,14),(2,51),(1,73)]



class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
         HashMap<Integer,Node[]>map=new HashMap<>();
         int idx=0;
         int[] res=new int[queries.length];
         for(int[] query:queries){
             Node []arr=new Node[nums.length];
             int key=query[1];
             if(!map.containsKey(key)){
                 int len=nums[0].length();
                 for(int i=0;i<nums.length;i++){
                     String s=nums[i].substring(len-key,len);
                     arr[i]=new Node(i,s);
                 }
                 Arrays.sort(arr,(a,b)->a.val.compareTo(b.val));
                 map.put(key,arr);
             }
             res[idx++]=map.get(key)[query[0]-1].index;
         }
         return res;
    }
    class Node{
        int index;
        String val;
        Node(int index,String val){
            this.index=index;
            this.val=val;
        }
    }
}