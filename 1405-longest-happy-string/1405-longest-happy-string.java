class Pair {
    int count;
    char ch;

    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> y.count - x.count);

        if(a>0) pq.offer(new Pair(a ,'a'));
        if(b>0) pq.offer(new Pair(b, 'b'));
        if(c>0) pq.offer(new Pair(c, 'c'));


        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){

           Pair pair = pq.poll();

            int count = pair.count;
            char ch = pair.ch;

            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == ch  && sb.charAt(sb.length()-2) == ch ){

                if(pq.isEmpty()) break;

               Pair secondPair = pq.poll();

                int secondPairCount = secondPair.count;
                char secondPairCh = secondPair.ch;

                sb.append(secondPairCh);
                secondPairCount--;

                if(secondPairCount > 0){
                    pq.offer(new Pair(secondPairCount,secondPairCh));
                }

            }
            else{
                sb.append(ch);
                count--;

            }

            if(count > 0){
                pq.offer(new Pair(count,ch));
            }
        }

        return sb.toString();
    }
}