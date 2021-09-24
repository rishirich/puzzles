import java.math.*;

class Solution {
    public int missingNumber(int[] arr) {
        int largestDifference = Integer.MIN_VALUE;
        int largestDiffStartIndex = 0;
        int largestDiffEndIndex = 1;
        for(int i=0; i< arr.length-1;i++) {
            if(Math.abs(arr[i+1]-arr[i]) > Math.abs(largestDifference)) {
                largestDifference = Math.abs(arr[i+1]-arr[i]);
                largestDiffStartIndex = i;
                largestDiffEndIndex = i+1;
            }
        }
        return (arr[largestDiffStartIndex] + arr[largestDiffEndIndex])/2;
    }
}