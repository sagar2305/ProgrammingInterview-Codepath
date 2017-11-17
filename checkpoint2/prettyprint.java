// https://www.interviewbit.com/problems/prettyprint/
// Print concentric rectangular pattern in a 2d matrix. 

public class Solution {
    public int[][] prettyPrint(int A) {
        int size = A*2 - 1;
        int[][] concentric = new int[size][size];
        
        for(int i=0; i< A*2-1; i++) {
            for(int j=0; j<A*2-1; j++) {
                int iVal = (i - 0) < (size-1) - i ? i : (size-1) - i;
                int jVal = j < (size-1) - j ? j : (size-1) - j;
                int offset = iVal < jVal ? iVal : jVal;
                
                concentric[i][j] = A - offset;
            }
        }
    
        return concentric;
    }
}
