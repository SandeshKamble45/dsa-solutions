class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0 ) return 0;
       Arrays.sort(arr);
        int count = 1, maxCount = 1;
        for(int i = 1; i< arr.length ; i++){
            if(arr[i - 1] == arr[i]){
                 continue;
            }else if( arr[i] - 1 == arr[i - 1]){
                 count++;
            }else{
                 count = 1;
            }
            maxCount = Math.max(count, maxCount);
        }

          return maxCount ;
      }
}
