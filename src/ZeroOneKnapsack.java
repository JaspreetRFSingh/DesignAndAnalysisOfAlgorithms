import java.util.Scanner;

public class ZeroOneKnapsack {

	 public void solution(int[] weights, int[] values, int W, int N)
	    {
	        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
	        int[][] m = new int[N + 1][W + 1];
	        int[][] sol = new int[N + 1][W + 1];
	        for (int i = 1; i <= N; i++)
	        {
	            for (int j = 0; j <= W; j++)
	            {
	                int m1 = m[i - 1][j];
	                int m2 = NEGATIVE_INFINITY; 
	                if (j >= weights[i])
	                    m2 = m[i - 1][j - weights[i]] + values[i];
	                m[i][j] = Math.max(m1, m2);
	                sol[i][j] = m2 > m1 ? 1 : 0;
	            }
	        }        
	        int[] selected = new int[N + 1];
	        for (int n = N, w = W; n > 0; n--)
	        {
	            if (sol[n][w] != 0)
	            {
	                selected[n] = 1;
	                w = w - weights[n];
	            }
	            else
	                selected[n] = 0;
	        }
	        System.out.print("\nItems with weight ");
	        for (int i = 1; i < N + 1; i++)
	            if (selected[i] == 1)
	                System.out.print(values[i] +" ");
	        System.out.println("are selected for Knapsack.");
	    }
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        ZeroOneKnapsack ks = new ZeroOneKnapsack();
 
        System.out.println("Enter number of elements: ");
        int n = scan.nextInt();
 
        int[] wt = new int[n + 1];
        int[] val = new int[n + 1];
 
        System.out.println("Enter weight for "+ n +" elements: ");
        for (int i = 1; i <= n; i++)
            wt[i] = scan.nextInt();
        System.out.println("Enter value for "+ n +" elements: ");
        for (int i = 1; i <= n; i++)
            val[i] = scan.nextInt();
        System.out.println("Enter knapsack weight: ");
        int W = scan.nextInt();
        ks.solution(wt, val, W, n);
        scan.close();	
	}
}
