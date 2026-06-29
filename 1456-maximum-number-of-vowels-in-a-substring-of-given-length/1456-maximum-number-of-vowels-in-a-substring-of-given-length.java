class Solution {
    public int maxVowels(String s, int k) {
        int ans =0;
        int max = 0;

        for(int i=0; i<k; i++){
            char ch = s.charAt(i);
            if( ch=='a' || ch =='e'|| ch=='i' || ch =='o' || ch == 'u' ){
                max++;
            }
        }
        ans = max;

        int left =0;
        for(int right= k ; right < s.length(); right++){
            char ch = s.charAt(left);
            if( ch=='a' || ch =='e'|| ch=='i' || ch =='o' || ch == 'u' ){
                max--;
            }
            left++;


            char c = s.charAt(right);
            if( c=='a' || c =='e'|| c=='i' || c =='o' || c == 'u' ){
                max++;
            }

            ans = Math.max(max,ans);
        }
        return ans;
    }
}