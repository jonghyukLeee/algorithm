import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Voca {
    String word;
    int count, length;

    public Voca(String word, int count, int length) {
        this.word = word;
        this.count = count;
        this.length = length;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCountMap = new HashMap<>();
        PriorityQueue<Voca> pq = new PriorityQueue<>(new Comparator<Voca>() {
            @Override
            public int compare(Voca o1, Voca o2) {
                if (o1.count == o2.count) {
                    if (o1.length == o2.length) {
                        return o1.word.compareTo(o2.word);
                    }
                    return o2.length - o1.length;
                }
                return o2.count - o1.count;
            }
        });
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.length() >= m) {
                wordCountMap.put(input, wordCountMap.getOrDefault(input, 0) + 1);
            }
        }

        for (String key: wordCountMap.keySet()) {
            pq.add(new Voca(key, wordCountMap.get(key), key.length()));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
