package Basic.day1;

import java.io.*;
import java.util.*;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char [] input = br.readLine().toCharArray();
        List<Character> list = new LinkedList<>();
        ListIterator<Character> it = list.listIterator();

        for(char c : input) it.add(c);

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("L"))
            {
                if(it.hasPrevious()) it.previous();
            }
            else if(cmd.equals("D"))
            {
                if(it.hasNext()) it.next();
            }
            else if(cmd.equals("B"))
            {
                if(it.hasPrevious())
                {
                    it.previous();
                    it.remove();
                }
            }
            else if(cmd.equals("P")) it.add(st.nextToken().charAt(0));
        }

        for(char c : list) bw.write(c);
        bw.flush();
        bw.close();
    }
}
