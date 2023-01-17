/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int peakIndex = findPeakIndex(arr);
        int incArr = orderAgnosticBS(target, 0, peakIndex, arr);
        if(incArr!=-1) return incArr;
        int decArr = orderAgnosticBS(target, peakIndex+1, arr.length()-1, arr);
        return decArr;
    }
    public int findPeakIndex(MountainArray arr) {
        int start=0;
        int end=arr.length()-1;
        while(start<end) {
            int mid=start+(end-start)/2;
            if(arr.get(mid)<arr.get(mid+1)) {
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
        return start;
    }
    public int orderAgnosticBS(int target, int start, int end, MountainArray arr) {
        boolean isAsc = arr.get(start)<arr.get(end);
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(target==arr.get(mid)) return mid;
            if(isAsc) {
                if(target>arr.get(mid)) {
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
            else {
                if(target>arr.get(mid)) {
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}