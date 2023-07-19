import java.util.*;

class maxSumAfterOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array length: ");
        int N = sc.nextInt();
        int A[] = new int[N];
        
        System.out.println("Enter the array elements: ");
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        System.out.println("Enter the number of operations: ");
        int B = sc.nextInt();
        
        // maxSum(A, B);
        
        System.out.println("Max sum after " + B + " operations: " + maxSum(A,B));
        sc.close();
    }

    public static int maxSum(int A[], int B) {
        int N = A.length;
        
        int pSum[] = new int[N];
        pSum[0] = A[0];

        for (int i=1; i<N; i++) {
            pSum[i] = pSum[i-1] + A[i];
        }

        int sSum[] = new int[N];        
        sSum[N-1] = A[N-1];

        for (int i=N-2; i>=0; i--) {
            sSum[i] = sSum[i+1] + A[i];
        }

        int mSum = Math.max(pSum[B-1], sSum[N-B]);

        for (int i=1; i<B; i++) {
            int sum = pSum[i-1] + sSum[N-(B-i)];
            mSum = Math.max(mSum, sum);
        }

        return mSum;

    }
}