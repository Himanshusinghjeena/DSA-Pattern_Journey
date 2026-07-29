class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            } else {
                st1.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            } else {
                st2.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();

        while (!st1.isEmpty()) {
            sb.append(st1.pop());
        }

        while (!st2.isEmpty()) {
            tb.append(st2.pop());
        }

        return sb.toString().equals(tb.toString());

        //     int i = s.length() - 1;
        //     int j = t.length() - 1;

        //     int skipS = 0, skipT = 0;

        //     while(i >= 0 || j >= 0){

        //         while(i >= 0){
        //             if(s.charAt(i) == '#'){
        //                 skipS++;
        //                 i--;
        //             }
        //             else if(skipS > 0){
        //                 skipS--;
        //                 i--;
        //             }
        //             else break;
        //         }

        //         while(j >= 0){
        //             if(t.charAt(j) == '#'){
        //                 skipT++;
        //                 j--;
        //             }
        //             else if(skipT > 0){
        //                 skipT--;
        //                 j--;
        //             }
        //             else break;
        //         }

        //         if(i >= 0 && j >= 0){
        //             if(s.charAt(i) != t.charAt(j)) return false;
        //         }
        //         else{
        //             if(i >= 0 || j >= 0) return false;
        //         }

        //         i--;
        //         j--;
        //     }

        //     return true;
    }
}