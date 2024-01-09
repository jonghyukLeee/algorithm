import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Point_20125 {
    int x, y;

    public Point_20125(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int [] dx = {0, 0, 1}; // 좌 우 하
    static int [] dy = {-1, 1, 0};
    static int N;
    static char [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        Point_20125 head = null;

        for (int i = 0; i < N; i++) {
            String lineInput = br.readLine();
            for (int j = 0; j < N; j++) {
                char currentChar = lineInput.charAt(j);
                map[i][j] = currentChar;
                if (head == null && currentChar == '*') {
                    head = new Point_20125(i, j);
                }
            }
        }

        Point_20125 heart = new Point_20125(head.x + 1, head.y);

        int leftArmLength = measure(heart.x, heart.y - 1, 0);
        int rightArmLength = measure(heart.x, heart.y + 1, 1);
        int waistLength = measure(heart.x + 1, heart.y, 2);
        int leftLegLength = measure(heart.x + waistLength + 1, heart.y - 1, 2);
        int rightLegLength = measure(heart.x + waistLength + 1, heart.y + 1, 2);

        System.out.printf("%d %d\n%d %d %d %d %d", heart.x + 1, heart.y + 1, leftArmLength, rightArmLength, waistLength, leftLegLength, rightLegLength);
    }

    public static int measure(int x, int y, int dir) {
        int length = 0;

        int mx = x;
        int my = y;

        while (isValid(mx, my) && map[mx][my] == '*') {
            length++;
            mx += dx[dir];
            my += dy[dir];
        }

        return length;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
