package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q9466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<int[]> arr = new ArrayList<>();
        int [] stu;
        while(t-- >0)
        {
            int n = Integer.parseInt(br.readLine());
            stu = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i)
            {
                stu[i] = Integer.parseInt(st.nextToken());
            }
            arr.add(stu);
        }

    }
}
