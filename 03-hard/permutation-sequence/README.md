# Permutation Sequence

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Math, Combinatorics &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/permutation-sequence)

## Problem

Directly find the kth permutation sequence of numbers 1..n, without generating all n! permutations.

## Approach

Use the factorial number system: repeatedly divide the remaining k by `(n-1)!`, `(n-2)!`, etc. to determine each digit's position in a shrinking list of remaining candidates, removing the chosen digit each time.

## Gotchas / Edge Cases

- k is 1-indexed in the problem statement — convert to 0-indexed first or every digit will be off.

## Complexity

- **Time:** O(n^2) (due to list removal at each step)
- **Space:** O(n)

## Solution

```java
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i< n ; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        String ans = "";
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0){
                 break;
            }
            k = k % fact;
            fact = fact / numbers.size() ;
        }
        return ans;
    }
}
```
