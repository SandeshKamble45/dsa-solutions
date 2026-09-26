class Solution {
    public int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i< arr.length ;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

      public int findSum(int[] arr){
          int sum = 0;
          for(int i = 0; i< arr.length ;i++){
              sum += arr[i];
          }
          return sum;
      }

      public int allocateSums(int[] arr, int max){
          int currSum = 0; int group = 1;
          for(int i = 0; i < arr.length; i++){
              if(currSum + arr[i] <= max){
                  currSum += arr[i];
              }else{
                  group++;
                  currSum = arr[i];
              }
          }
          return group;
      }

      public int splitArray(int[] nums, int k) {
          int n = nums.length;
          if(k > n) return -1;
          int low = findMax(nums); int high = findSum(nums);
          while(low <= high){
              int mid = low + (high - low)/2;
              int split = allocateSums(nums, mid);
              if(split <= k){
                  high = mid - 1;
              }else{
                  low = mid + 1;
              }
          }
          return low;
      }
}
