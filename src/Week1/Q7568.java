package Week1;

import java.io.*;
import java.util.StringTokenizer;

class Student
{
    int height,weight,rank = 1;

    public Student(int height,int weight)
    {
        this.height = height;
        this.weight = weight;
    }
}
public class Q7568 {
    static Student body [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        body = new Student[t];
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            body[i] = new Student(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < t; ++i)
        {
            for(int j = 0; j < t; ++j)
            {
                if(body[i].height < body[j].height && body[i].weight < body[j].weight)
                {
                    body[i].rank++;
                }
            }
        }
        for(int i = 0; i < t; ++i)
        {
            sb.append(body[i].rank+" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
