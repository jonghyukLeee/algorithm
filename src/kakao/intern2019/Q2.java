package kakao.intern2019;

import com.sun.source.tree.Tree;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {

    }
    static int [] solution(String s)
    {
        int[] answer;
        StringTokenizer st = new StringTokenizer(s,"{},");
        Map<String,Integer> hm = new HashMap<>();
        while(st.hasMoreTokens())
        {
            String next = st.nextToken();
            hm.put(next,hm.getOrDefault(next,0)+1);
        }
        answer = new int[hm.size()];
        List<Map.Entry<String,Integer>> sortedMap = new ArrayList<>(hm.entrySet());
        Collections.sort(sortedMap,new Comparator<Map.Entry<String,Integer>>()
        {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int idx = 0;
        for(Map.Entry<String,Integer> next : sortedMap)
        {
            answer[idx++] = Integer.parseInt(next.getKey());
        }
        return answer;
    }
}
