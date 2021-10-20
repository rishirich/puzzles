class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int minSize;
    int maxSize;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        minSize = 0;
        maxSize = 0;
    }
    
    public void addNum(int num) {
       if (minSize == 0) {
           min.add(num);
           minSize++;
           return;
       }
       if (minSize >= maxSize) {
           if (num > min.peek()) {
               int temp = min.poll();
               min.add(num);
               max.add(temp);
           }
           else max.add(num);
           maxSize++;
           }
        else {
            if (num < max.peek()) {
                int temp = max.poll();
                max.add(num);
                min.add(temp);
            }
            else min.add(num);
            minSize++;
        }
       }
    
    public double findMedian() {
        if (maxSize == minSize) return (max.peek() + min.peek())/2.0;
        else if (maxSize > minSize) return max.peek();
        else return min.peek();
    }
}