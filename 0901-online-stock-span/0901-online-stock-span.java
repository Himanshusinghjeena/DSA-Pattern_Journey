class StockSpanner {

    Stack<Integer> st;
    ArrayList<Integer> prices;

    public StockSpanner() {
        st = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int currIndex = prices.size() - 1;


        while(!st.isEmpty() && prices.get(st.peek()) <= price){
            st.pop();
        }

        int span=1;
        if (st.isEmpty()) {
            span = currIndex + 1;
        } else {
            span = currIndex - st.peek();
        }

        st.push(currIndex);

        return span;

    }
}

