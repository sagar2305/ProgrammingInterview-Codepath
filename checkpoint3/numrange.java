// https://www.interviewbit.com/problems/numrange/
// Given an array of non negative integers A, and a range (B, C), 
// find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

public class Solution {
    public int numRange(int[] A, int B, int C) {
        int i = 0;
        int counter = 0;
        int j = 0;
        
        while (i < A.length) {
            
            if (A[i] > C) {
                i += 1;
            } else {
                int sum = A[i];
                if (sum >=B && sum <=C) {
                    counter += 1;
                }
                j = i + 1;
                if (j == A.length) 
                    break;
                
                while (true) {
                    sum += A[j];
                    if (sum >= B && sum <= C) {
                        counter += 1;
                        j += 1;
                        if (j == A.length) 
                            break;
                    } else if (sum < B) {
                        j += 1;
                        if (j == A.length) 
                            break;
                    } else {
                        break;
                    }
                }
                i += 1;
            }
        }
        
        return counter;
    }
}

