package sample.fb.interview.solution;


public class CombinationSumIV {
	
	public static int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                
                if(i - nums[j] >= 0) {
                    
                    dp[i] += dp[i - nums[j]];
                    
                }
                
            }
            
        }
        
        return dp[target];
        
    }

	public static void main(String[] argv) {
		System.out.println(combinationSum4(new int[]{1,2,3},4));
	}

}