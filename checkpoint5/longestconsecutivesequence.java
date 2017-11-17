// https://www.interviewbit.com/problems/longest-consecutive-sequence/

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example: 
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
    
        HashSet numSet = new HashSet();
        for(int i = 0; i < A.length; i++) {
            numSet.add(A[i]); 
        }
        
        int maxStreak = 0;
        
        for(int i = 0; i < A.length; i++) {
            int currentNum = A[i];
            
            int currentStreak = 0;
            //currentNum is the first in the sequence
            if (!numSet.contains(currentNum - 1)) {
                
                int j = currentNum;
                while(numSet.contains(j++)) {
                    currentStreak += 1;
                }
                
                maxStreak = maxStreak < currentStreak ? currentStreak : maxStreak;
            }
        }
        return maxStreak;
    }
}
