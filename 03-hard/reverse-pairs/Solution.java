class Solution {
    public int merge(int low, int high, int[] arr){
        int count = 0;
        if(low >= high) return count;
        int mid = low + (high - low) / 2;
        count += merge(low, mid, arr);
        count += merge(mid+1, high, arr);
        count += count(low, mid, high, arr);
        mergeSort(low, mid, high , arr);
        return count;
    }

      public void mergeSort(int low, int mid, int high , int[] arr){
          int l = low ; int r = mid+1;
          List<Integer> temp = new ArrayList<>();
          while(l <= mid && r <= high){
              if( arr[l] <= arr[r]){
                  temp.add(arr[l]);
                  l++;
              }else{
                  temp.add(arr[r]);
                  r++;
              }
          }

          while(l <= mid ){
              temp.add(arr[l]);
                  l++;
          }
          while(r <= high){
              temp.add(arr[r]);
                  r++;
          }

          for(int i = 0 ; i< temp.size(); i++){
              arr[low + i] = temp.get(i);
          }
      }

      public int count(int low, int mid, int high, int[] arr){
          int l = low; int r = mid+1; int count = 0;
          for(int i = l ; i<= mid; i++){
              while( r <= high && arr[i] > 2L * arr[r] ){
                  r++;
              }
              count += r - (mid + 1);
          }
          return count;
      }

      public int reversePairs(int[] nums) {
          int n = nums.length;
          int count = 0;
          count += merge(0 , n-1, nums);
          return count;
      }
}
