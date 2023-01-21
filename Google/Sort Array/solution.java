class Solution {
    public int[] sortArray(int[] nums) {
        //O(nlogn) --> Quicksort
        sortArray(nums, 0, nums.length-1);
        return nums;

    }
    private void sortArray(int[] nums, int low, int high){
        if(low < high){
            int pivot = partition(nums, low, high);
            sortArray(nums,low,pivot);
            sortArray(nums,pivot+1,high);

        
        }
    }
    private int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low-1;
        int j=high +1;
        while(true){
            do{
                i++;

            } while(nums[i]<pivot);
            do{
                j--;

            } while(nums[j]> pivot);
            if(i >= j){
                return j;

            }
            swap(nums,i,j);

        }

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
}