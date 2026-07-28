class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(ch);
            } else {
                char top = st.peek();
                if (top == ch) {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}