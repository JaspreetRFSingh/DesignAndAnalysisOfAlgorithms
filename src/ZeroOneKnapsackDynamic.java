
public class ZeroOneKnapsackDynamic {

	private static int knapsack(int[] w, int[] v, int W) {
	  int[][] dp = new int[w.length][W + 1];
	  dp[0][0] = 0;
	  for(int i = 1 ; i < dp[0].length; i++){
	    if(w[0] <= i){
	      dp[0][i] = v[0];
	    }else{
	      dp[0][i] = 0;
	    }
	  }
			
	  for (int i = 1; i < dp.length; i++) {
	    for (int j = 1; j < dp[i].length; j++) {
	      // if a weight is more than the allowed weight, that weight cannot be picked.
	        if(w[i] > j){
	          dp[i][j] = dp[i-1][j];
	        }else{
	          dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
	        }
	      }
	    }
	    return dp[dp.length-1][W];
	}
	public static void main(String[] args) {
		int w[] = new int[]{3,2,5,1,4,3};
		int v[] = new int[]{20,15,30,35,40,10};
		int W = 9;
		System.out.println(knapsack(w,v,W));
	}

}

