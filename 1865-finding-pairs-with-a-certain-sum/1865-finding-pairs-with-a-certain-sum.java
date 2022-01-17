class FindSumPairs {

    int[] nums1, nums2;
    HashMap<IntegerNode,IntegerNode> nums2Map = new HashMap<>();
    
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i=0;i<nums2.length;i++) {
            IntegerNode integerNode = new IntegerNode(nums2[i]);
            if(!nums2Map.containsKey(integerNode))
                nums2Map.put(integerNode,integerNode);
            else
                nums2Map.get(integerNode).increaseCount();
        }
    }
    
    public void add(int index, int val) {
        IntegerNode oldNode = nums2Map.get(new IntegerNode(nums2[index]));
        if(oldNode !=null) {
            oldNode.decreaseCount();
        }
        nums2[index] += val;
        IntegerNode integerNode = new IntegerNode(nums2[index]);
            if(!nums2Map.containsKey(integerNode))
                nums2Map.put(integerNode,integerNode);
            else
                nums2Map.get(integerNode).increaseCount();
    }
    
    public int count(int tot) {
        int count=0;
        for(int i=0;i<nums1.length;i++) {
            IntegerNode integerNode = new IntegerNode(tot-nums1[i]);
            if(nums2Map.containsKey(integerNode))
                count += nums2Map.get(integerNode).getCount();
        }
        return count;
    }
}

class IntegerNode {
    private int count = 0;
    private Integer num;
    
    public IntegerNode(int num) {
        this.num = num;
        this.count = 1;
    }
    
    public void increaseCount() {
        this.count++;
    }
    
    public void decreaseCount() {
        this.count--;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public int getNum(){
        return this.num;
    }
    
    @Override
    public int hashCode()  {
        return Integer.hashCode(this.num);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IntegerNode) {
            return this.hashCode() == ((IntegerNode)obj).hashCode();
        }
        return false;
    }
    
    
    
    
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */