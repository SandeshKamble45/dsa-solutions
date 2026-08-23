class Solution {
    public int trap(int[] ht) {
        int n = ht.length;
        int low = 0; int high = n - 1;
        int lmax = 0; int rmax = 0; int count = 0;
        while(low <= high){
            lmax = Math.max(lmax, ht[low]);
            rmax = Math.max(rmax, ht[high]);
            if(lmax <= rmax){
                 count += lmax - ht[low];
                 low++;
            }else{
                 count += rmax - ht[high];
                 high--;
            }
        }
        return count;
    }
}
