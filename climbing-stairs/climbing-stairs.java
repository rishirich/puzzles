class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return this.numWaysToClimb(n, memo);
    }
    
    private int numWaysToClimb(int n, int[] memo) {
        if(memo[n]>0)
            return memo[n];
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        memo[n] = numWaysToClimb(n-1,memo) + numWaysToClimb(n-2,memo);
        return memo[n];
    }
}