class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> tripletsList = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            int currSum = 0 - nums[i];
            HashSet<Integer> set = new HashSet();
            for(int j=i+1;j<nums.length;j++) {
                if(set.contains(currSum - nums[j])) {
                    List<Integer> triplet = new ArrayList();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(currSum - nums[j]);
                        tripletsList.add(triplet);
                }
            set.add(nums[j]);
            }
        }
        return new ArrayList<List<Integer>>(tripletsList);
    }
}