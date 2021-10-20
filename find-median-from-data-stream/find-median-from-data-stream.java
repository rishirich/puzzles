class MedianFinder {
 
    
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    
    
    
    
    public void addNum(int num) {
        System.out.println("Inserting element " + num);
        if(!minHeap.isEmpty() &&  num < minHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        rebalanceHeaps();
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek())/2.0;
        else if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        return minHeap.peek();
    }
    
    
    private void rebalanceHeaps() {
        if(maxHeap.size() - minHeap.size() > 1) {
            int removedNum = maxHeap.poll();
            minHeap.add(removedNum);
        } else if(minHeap.size() - maxHeap.size() > 1) {
            int removedNum = minHeap.poll();
            maxHeap.add(removedNum);
        }
    }
}

public class MaxHeap {
        int size = 0;
        int[] heap = new int[10];
        
        public void print(String type) {
            System.out.println(type + "Heap is");
            for(int i=0;i<size;i++) 
                System.out.println(heap[i]);
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
        
        public int getSize() {
            return this.size;
        }
    
        public void addNum(int num) {
            this.resizeHeapIfNeeded();
            heap[size++] = num;
            heapifyUp();
        }
    
        
        public int getTop() {
            if(size>0)
                return heap[0];
            return Integer.MIN_VALUE;
        }
    
        public int extractTop() {
            int removedItem = Integer.MIN_VALUE;
            if(size>0) {
                removedItem = heap[0];
                heap[0] = heap[size-1];
                size--;
                heapifyDown();
            }
            return removedItem;
        }
    
        private void heapifyDown() {
            int index = 0;
            while(hasLeftChild(index)) {
                int smallerChildIndex = leftChild(index);
                if(hasRightChild(index) && heap[smallerChildIndex] < heap[rightChild(index)])
                    smallerChildIndex = rightChild(index);
                System.out.println("Comparing " + heap[index] + " and "  + heap[smallerChildIndex]);
                if(heap[index] < heap[smallerChildIndex]) {
                    System.out.println("Swapping " + heap[index] + " and "  + heap[smallerChildIndex]);
                    swap(index,smallerChildIndex);
                    index = smallerChildIndex;
                } else
                    break;
            }
        }
    
        private void heapifyUp() {
            int index = size-1;
            while(hasParent(index) && heap[index] > heap[parent(index)]) {
                swap(index,parent(index));
                index = parent(index);
            }
        }
    
        private void resizeHeapIfNeeded() {
            if(size == (heap.length-1)) {
                heap = Arrays.copyOf(heap,heap.length*2);
            }
        }
        
        private void swap(int a, int b) {
            heap[a] = heap[a] + heap[b];
            heap[b] = heap[a] - heap[b];
            heap[a] = heap[a] - heap[b];
        }
    
        private boolean hasParent(int index) {
            return ((index-1)/2 >=0);
        }
    
        private int parent(int index) {
            return (index-1)/2;
        }
        
        private boolean hasLeftChild(int index) {
            return (index*2+1)<size;
        }
    
        private boolean hasRightChild(int index) {
            return (index*2+2)<size;
        }
    
        private int leftChild(int index) {
            return index*2+1;
        }
    
        private int rightChild(int index) {
            return index*2+2;   
        }
}