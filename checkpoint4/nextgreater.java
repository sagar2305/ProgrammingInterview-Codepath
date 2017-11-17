// https://www.interviewbit.com/problems/nextgreater/

/*
Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.
*/

public class Solution {
    public int[] nextGreater(int[] A) {
        
        for(int i = 0; i < A.length; i++) {
            int j = i;
            while(++j < A.length) {
                if(A[j] > A[i]) {
                    A[i] = A[j];
                    break;
                }
            }
            
            if(j == A.length) {
                A[i] = -1;
            }
        }
        
        return A;
    }
}
