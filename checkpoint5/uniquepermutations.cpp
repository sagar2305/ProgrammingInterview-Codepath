// https://www.interviewbit.com/problems/all-unique-permutations/

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]
*/

void perm(vector<int> num,int k,int n, vector<vector<int> > &res);

vector<vector<int> > Solution::permute(vector<int> &A) {
    vector<vector<int> > res;
    perm(A, 0, A.size(), res);
    return res;
}

bool duplicate(const vector<int> A, int k, int i) {
    for (int j=k; j<i; j++) {
        if (A[j] == A[i]) {
            return true;
        }
    }
    
    return false;
}

//dont forget &
void swap (vector<int> &A, int i, int k) {
    int temp = A[i];
    A[i] = A[k];
    A[k] = temp;
}
 
void perm(vector<int> A, int k, int n, vector<vector<int> > &res) {
    if (k == n) {
        res.push_back(A);
    } else {
        for (int i=k; i<n; i++) {
                 
            if (duplicate(A, k, i)) { continue; }
                 
            swap(A, i, k);
            perm(A, k+1, n, res);
            swap(A, i, k);
        }
    }
}
