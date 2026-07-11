class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];
        for(int i = 1; i< n; i++ ){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if( currStart <= lastEnd ){
                 lastEnd = Math.max(lastEnd, currEnd);
            }else{
                 ans.add(new int[]{lastStart, lastEnd});
                 lastStart = currStart;
                 lastEnd = currEnd;
            }
        }
        ans.add(new int[]{lastStart, lastEnd});
        return ans.toArray( new int[ans.size()][]);
    }
}
