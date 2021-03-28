package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q1655 {
    static ArrayList<Integer> al;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        al = new ArrayList<Integer>();
        int tmp,size;
        while(t-- > 0)
        {
            tmp = Integer.parseInt(br.readLine());
            al.add(tmp);
            Collections.sort(al);
            size = al.size();
            if(size % 2 == 0)
            {
                int n1 = al.get(size/2), n2 = al.get((size/2)-1);
                sb.append(Math.min(n1,n2));
                sb.append("\n");
            }
            else
            {
                sb.append(al.get(size/2));
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
