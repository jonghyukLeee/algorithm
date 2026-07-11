import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String key = br.readLine();

        boolean[] checked = new boolean[26];
        map = new char[5][5];
        checked[9] = true; // J
        int keySize = key.length();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < keySize; i++) {
            char cur = key.charAt(i);
            if (!checked[cur - 65]) {
                q.add(cur);
                checked[cur - 65] = true;
            }
        }

        int alphaCursor = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!q.isEmpty()) {
                    map[i][j] = q.poll();
                } else {
                    while (checked[alphaCursor]) { 
                        alphaCursor++;
                    }
                    map[i][j] = (char)(alphaCursor++ + 65);
                }
            }
        }
        Queue<Character[]> mq = new LinkedList<>();
        int messageSize = message.length();
        for (int i = 0; i < messageSize; i++) {
            char cur = message.charAt(i);
            int nextIdx = i + 1;
            char nextChar;
            if (nextIdx == messageSize) {
                nextChar = 'X';
            } else {
                nextChar = message.charAt(nextIdx);
                if (cur == nextChar) {
                    nextChar = cur == 'X' ? 'Q' : 'X';
                } else {
                    i++;
                }
            }
            mq.add(new Character[]{cur, nextChar});
        }

        StringBuilder sb = new StringBuilder();
        while (!mq.isEmpty()) {
            Character[] cur = mq.poll();
            int lx = 0;
            int ly = 0;
            int rx = 0;
            int ry = 0;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == cur[0]) {
                        lx = i;
                        ly = j;
                    }
                    if (map[i][j] == cur[1]) {
                        rx = i;
                        ry = j;
                    }
                }
            }

            if (lx == rx) {
                ly = (ly + 1) % 5;
                ry = (ry + 1) % 5;
            } else if (ly == ry) {
                lx = (lx + 1) % 5;
                rx = (rx + 1) % 5;
            } else {
                int tmp = ly;
                ly = ry;
                ry = tmp;
            }
            sb.append(map[lx][ly]).append(map[rx][ry]);
        }
        System.out.print(sb.toString());
    }
}