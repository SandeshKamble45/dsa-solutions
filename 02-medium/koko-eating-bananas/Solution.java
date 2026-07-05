class Solution {
    public int findMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i< arr.length ; i++){
            if(arr[i] > max){
                 max = arr[i];
            }
        }
        return max;
    }

      public long computeTotalHours(int[] arr , int mid){
          long totalHours = 0;
          for(int i = 0; i < arr.length; i++){
              totalHours += (arr[i] + mid - 1) / mid ;
          }
          return totalHours;
      }

      public int minEatingSpeed(int[] piles, int h) {
          int low = 1; int high = findMax(piles);
          while( low <= high ){
              int mid = low + (high - low)/2;
              long totalHours = computeTotalHours(piles, mid);
              if(totalHours <= h){
                  high = mid - 1;
              }else{
                  low = mid + 1;
              }
          }
          return low;
      }
}
