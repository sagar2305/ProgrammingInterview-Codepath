// https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
// Find the kth smallest element in an unsorted array of non-negative integers.

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
int kthsmallest(const int* A, int n1, int k) {
    
    int low = 0;
    int high = n1 - 1;

    int index = k - 1;
    while (high > low) {
        int j = partition(A, low, high);
        // printf("j = %d\n", j);
        if (j < index) {
            low = j + 1;
        } else if (j > index) {
            high = j - 1;
        } else {
            return A[index];
        }
    }
    
    return A[index];
}
 
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
 
// Standard partition process of QuickSort().  It considers the last
// element as pivot and moves all smaller element to left of it
// and greater elements to right
int partition(int a[], int low, int high) {
    
    int i = low;
    int j = high + 1;
    int k = a[low];
    
    while (1) {
        while (a[++i] < k) {
            if (i == high)
                break;
        }
        
         while (a[--j] > k) {
            if (j == low) 
                break;
        }
        
        if (i >= j)
            break;
            
        swap(&a[i], &a[j]);
    }
    swap(&a[low], &a[j]);

    return j;
}
