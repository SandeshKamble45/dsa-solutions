class Solution {
    Random rand = new Random();

      public int ans;
      public void swap(int[] nums, int i, int j){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }

      public int findPartition(int[] nums, int low, int high){
          int random = low + rand.nextInt(high - low + 1);
          swap(nums, random, low);
          int pivot = nums[low];
          int i = low; int j = high;
          while( i < j){
              while(nums[i] <= pivot && i < high) i++;
              while( nums[j] > pivot && j > low ) j--;
              if( i < j){
                  swap(nums, i, j);
              }
          }
          swap(nums, low, j);
          return j;
      }

      public int sort(int[] nums, int low, int high, int target){
          int pI = findPartition(nums, low, high);
          if(pI == target){
              return nums[pI];
          }else if(pI < target){
             return sort(nums, pI + 1, high, target);
          }else{
              return sort(nums, low, pI - 1, target);
          }
      }

      public int findKthLargest(int[] nums, int k) {
          int n = nums.length;
          int low = 0;
          int high = n - 1;
          int target = n - k;
          return sort(nums, low, high , target);
      }
}
