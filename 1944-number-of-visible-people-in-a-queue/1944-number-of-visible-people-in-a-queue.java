class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];


        ans[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(heights[n-1]);

        for(int i= n-2; i>=0; i--){
            int count =0;

            while(!st.isEmpty() && heights[i] > st.peek()){
                count++;
                st.pop();
            }

            if(!st.isEmpty()){
                count++;
            }

            ans[i] = count;
            st.push(heights[i]);

        }
        return ans;
    }
}