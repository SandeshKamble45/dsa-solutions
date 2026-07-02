class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length-1; int mid = Integer.MIN_VALUE;
        while(low <= high){
              mid = (low + high )/ 2;
            if(nums[low] <= nums[high]){
                 return nums[low];
            }
            if(nums[low] <= nums[mid]){
                 low = mid + 1;
            }else{
                 high = mid;
            }
        }
        return -1;
    }
}
