class Solution {
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       int index = -1;
       int breakpoint = 0;
       for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                 index = i;
                 break;
            }
        }

          if(index    == -1){
                     int l = 0; int r = n-1;
                        while(l < r){
                            int temp = nums[l];
                            nums[l] = nums[r];
                            nums[r] = temp;
                            l++; r--;
                        }
          }

          else{
              for(int i = n-1 ; i >= index; i--){
                  if(nums[i] > nums[index]){
                      int temp = nums[i];
                          nums[i]= nums[index];
                          nums[index] = temp;
                          break;
                  }
              }

              int l = index + 1; int r = n-1;
              while(l < r){
                  int temp = nums[l];
                  nums[l] = nums[r];
                  nums[r] = temp;
                  l++; r--;
              }
          }
      }
}
