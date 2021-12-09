package First.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer,Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int tmp;
        for(int i = 0; i< n; ++i)
        {
            tmp = Integer.parseInt(st.nextToken());
            if(hm.putIfAbsent(tmp,1)!=null)
            {
                hm.replace(tmp,hm.get(tmp)+1);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; ++i)
        {
            tmp = Integer.parseInt(st.nextToken());
            if(hm.get(tmp)==null)
            {
                sb.append("0 ");
            }
            else
            {
                sb.append(hm.get(tmp));
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }

}
