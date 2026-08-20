class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int len = tasks.length;

          for(char ch : tasks){
              map.put(ch, map.getOrDefault(ch, 0) + 1);
          }
          int maxFreq = Integer.MIN_VALUE;
          int maxCount = 0;

          for(Map.Entry<Character, Integer> entry : map.entrySet() ){
              maxFreq = Math.max(maxFreq, entry.getValue());
          }

          for(Map.Entry<Character, Integer> entry : map.entrySet() ){
              if(entry.getValue() == maxFreq){
                  maxCount++;
              }
          }

          int t = (maxFreq - 1) * (n + 1) + maxCount ;
          return Math.max(len, t);

      }
}
