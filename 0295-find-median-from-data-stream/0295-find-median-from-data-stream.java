class MedianFinder {
    PriorityQueue<Integer> max ;
    PriorityQueue<Integer> min ;


    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        if(max.size() == 0) {
            max.offer(num);
            return;
        }

        if(max.size() == min.size()){

            if(num > max.peek()){
                min.offer(num);
                max.offer(min.poll());
            }
            else{
                max.offer(num);
            }
        }else{
            max.offer(num);
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()) return (max.peek()+min.peek()) / 2.0;

        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */