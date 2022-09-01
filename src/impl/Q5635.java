package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student
{
    String name;
    int day,month,year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
public class Q5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Student> al = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            al.add(new Student(name,day,month,year));
        }
        //어린순서
        al.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o2.year == o1.year) {
                    if (o2.month == o1.month) return o2.day - o1.day;
                    return o2.month - o1.month;
                }
                return o2.year - o1.year;
            }
        });

        System.out.printf("%s\n%s",al.get(0).name,al.get(al.size()-1).name);
    }
}
