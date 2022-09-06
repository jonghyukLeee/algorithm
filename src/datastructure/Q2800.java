package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int left, right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Q2800 {
    static List<Pair> pairs;
    static int pairCount;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Integer> stk = new Stack<>();
        set = new TreeSet<>();

        pairs = new ArrayList<>();

        int inputSize = input.length();
        for (int i = 0; i < inputSize; i++) {
            char cur = input.charAt(i);
            if (cur == '(') {
                stk.add(i);
            } else if (cur == ')') {
                pairs.add(new Pair(stk.pop(), i));
            }
        }

        pairCount = pairs.size();
        makeString(0, input + "");

        // 입력값은 제거
        set.remove(input);

        StringBuilder answer = new StringBuilder();
        for (String s : set) {
            answer.append(s).append("\n");
        }

        System.out.print(answer);
    }

    static void makeString(int idx, String str) {
        if (idx == pairCount) {
            //공백 제거 후 set에 add
            set.add(str.replaceAll(" ", ""));
            return;
        }

        // 현재 괄호를 제거
        Pair pair = pairs.get(idx);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(pair.left, ' ');
        sb.setCharAt(pair.right, ' ');
        makeString(idx + 1, sb.toString());

        // 제거 안함
        makeString(idx + 1, str);
    }
}
