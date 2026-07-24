import java.io.*;
import java.util.*;

public class Main {

    static class Santa {
        int r;
        int c;
        boolean alive = true;

        Santa(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int M;
    static int P;
    static int C;
    static int D;

    static int rudolfR;
    static int rudolfC;

    static Santa[] santas;
    static int[] scores;

    /*
     * stunUntil[i]가 현재 턴 이상이면 이동 불가.
     *
     * t턴에 충돌하면:
     * t턴, t+1턴 이동 불가
     * t+2턴부터 이동 가능
     *
     * 따라서 충돌 시 turn + 1 저장.
     */
    static int[] stunUntil;

    // map에는 산타 번호만 저장한다. 루돌프는 저장하지 않는다.
    static int[][] map;

    static int outCount;

    // 루돌프 8방향
    static final int[] RUDOLF_DR = {
        -1, -1, 0, 1, 1, 1, 0, -1
    };

    static final int[] RUDOLF_DC = {
        0, 1, 1, 1, 0, -1, -1, -1
    };

    // 산타 이동 우선순위: 상 → 우 → 하 → 좌
    static final int[] SANTA_DR = {-1, 0, 1, 0};
    static final int[] SANTA_DC = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        rudolfR = Integer.parseInt(st.nextToken());
        rudolfC = Integer.parseInt(st.nextToken());

        santas = new Santa[P + 1];
        scores = new int[P + 1];
        stunUntil = new int[P + 1];
        map = new int[N + 1][N + 1];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            santas[number] = new Santa(r, c);
            map[r][c] = number;
        }

        for (int turn = 1; turn <= M; turn++) {
            if (outCount == P) {
                break;
            }

            moveRudolf(turn);

            if (outCount == P) {
                break;
            }

            moveSantas(turn);

            // 턴 종료 후 생존 산타에게 1점
            for (int i = 1; i <= P; i++) {
                if (santas[i].alive) {
                    scores[i]++;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= P; i++) {
            answer.append(scores[i]);

            if (i < P) {
                answer.append(' ');
            }
        }

        System.out.println(answer);
    }

    /**
     * 루돌프 이동
     */
    static void moveRudolf(int turn) {
        int target = findTargetSanta();

        Santa targetSanta = santas[target];

        /*
         * 목표 산타 방향으로 행과 열을 각각 1칸씩 줄인다.
         *
         * Integer.compare(a, b):
         * a > b : 1
         * a = b : 0
         * a < b : -1
         */
        int dr = Integer.compare(targetSanta.r, rudolfR);
        int dc = Integer.compare(targetSanta.c, rudolfC);

        rudolfR += dr;
        rudolfC += dc;

        // 루돌프가 이동한 위치에 산타가 있는 경우 충돌
        int collidedSanta = map[rudolfR][rudolfC];

        if (collidedSanta > 0) {
            scores[collidedSanta] += C;
            stunUntil[collidedSanta] = turn + 1;

            /*
             * 루돌프가 이동한 방향으로 산타를 C칸 밀어낸다.
             * 충돌 위치는 현재 루돌프 위치다.
             */
            knockback(
                collidedSanta,
                rudolfR,
                rudolfC,
                dr,
                dc,
                C
            );
        }
    }

    /**
     * 루돌프가 추적할 산타 선택
     *
     * 우선순위:
     * 1. 거리 최소
     * 2. 행 번호 최대
     * 3. 열 번호 최대
     */
    static int findTargetSanta() {
        int target = -1;
        int minDistance = Integer.MAX_VALUE;
        int maxRow = -1;
        int maxColumn = -1;

        for (int i = 1; i <= P; i++) {
            Santa santa = santas[i];

            if (!santa.alive) {
                continue;
            }

            int distance = getDistance(
                rudolfR,
                rudolfC,
                santa.r,
                santa.c
            );

            if (distance < minDistance) {
                target = i;
                minDistance = distance;
                maxRow = santa.r;
                maxColumn = santa.c;
            } else if (distance == minDistance) {
                if (santa.r > maxRow) {
                    target = i;
                    maxRow = santa.r;
                    maxColumn = santa.c;
                } else if (
                    santa.r == maxRow &&
                    santa.c > maxColumn
                ) {
                    target = i;
                    maxColumn = santa.c;
                }
            }
        }

        return target;
    }

    /**
     * 산타들을 번호 순서대로 이동
     */
    static void moveSantas(int turn) {
        for (int number = 1; number <= P; number++) {
            Santa santa = santas[number];

            // 탈락한 산타
            if (!santa.alive) {
                continue;
            }

            // 기절한 산타
            if (stunUntil[number] >= turn) {
                continue;
            }

            int currentDistance = getDistance(
                santa.r,
                santa.c,
                rudolfR,
                rudolfC
            );

            int selectedDirection = -1;
            int minDistance = currentDistance;

            /*
             * 상 → 우 → 하 → 좌 순서.
             *
             * dist < minDistance만 사용하면
             * 거리가 같은 경우 먼저 발견한 방향이 유지된다.
             */
            for (int direction = 0; direction < 4; direction++) {
                int nextR = santa.r + SANTA_DR[direction];
                int nextC = santa.c + SANTA_DC[direction];

                if (!isValid(nextR, nextC)) {
                    continue;
                }

                // 다른 산타가 있는 칸으로 이동할 수 없음
                if (map[nextR][nextC] > 0) {
                    continue;
                }

                int nextDistance = getDistance(
                    nextR,
                    nextC,
                    rudolfR,
                    rudolfC
                );

                // 현재보다 가까워지는 경우만 이동 가능
                if (nextDistance < minDistance) {
                    minDistance = nextDistance;
                    selectedDirection = direction;
                }
            }

            // 이동 가능한 방향이 없음
            if (selectedDirection == -1) {
                continue;
            }

            int oldR = santa.r;
            int oldC = santa.c;

            int nextR = oldR + SANTA_DR[selectedDirection];
            int nextC = oldC + SANTA_DC[selectedDirection];

            // 기존 위치 제거
            map[oldR][oldC] = 0;

            // 산타가 루돌프에게 이동하여 충돌
            if (nextR == rudolfR && nextC == rudolfC) {
                scores[number] += D;
                stunUntil[number] = turn + 1;

                /*
                 * 산타가 이동한 반대 방향으로 D칸 밀려난다.
                 */
                int knockbackDr = -SANTA_DR[selectedDirection];
                int knockbackDc = -SANTA_DC[selectedDirection];

                knockback(
                    number,
                    rudolfR,
                    rudolfC,
                    knockbackDr,
                    knockbackDc,
                    D
                );
            } else {
                // 일반 이동
                santa.r = nextR;
                santa.c = nextC;

                map[nextR][nextC] = number;
            }
        }
    }

    /**
     * 산타 밀어내기 및 연쇄 상호작용
     *
     * @param number 밀려나는 산타 번호
     * @param startR 충돌이 발생한 기준 행
     * @param startC 충돌이 발생한 기준 열
     * @param dr 밀려나는 행 방향
     * @param dc 밀려나는 열 방향
     * @param power 밀려나는 거리
     */
    static void knockback(
        int number,
        int startR,
        int startC,
        int dr,
        int dc,
        int power
    ) {
        /*
         * 루돌프 충돌의 경우 start 위치에 산타가 있다.
         * 연쇄 밀림에서도 start 위치에 산타가 있다.
         *
         * 산타가 루돌프에게 충돌한 경우에는 start 위치가
         * 루돌프 위치이므로 map에는 산타가 없다.
         */
        if (
            isValid(startR, startC) &&
            map[startR][startC] == number
        ) {
            map[startR][startC] = 0;
        }

        int landingR = startR + dr * power;
        int landingC = startC + dc * power;

        // 격자 밖으로 밀려나면 탈락
        if (!isValid(landingR, landingC)) {
            santas[number].alive = false;
            santas[number].r = 0;
            santas[number].c = 0;

            outCount++;
            return;
        }

        /*
         * 착지 지점에 다른 산타가 있다면
         * 같은 방향으로 1칸 밀어낸다.
         */
        int otherSanta = map[landingR][landingC];

        if (otherSanta > 0) {
            knockback(
                otherSanta,
                landingR,
                landingC,
                dr,
                dc,
                1
            );
        }

        // 현재 산타 착지
        santas[number].r = landingR;
        santas[number].c = landingC;

        map[landingR][landingC] = number;
    }

    static int getDistance(
        int r1,
        int c1,
        int r2,
        int c2
    ) {
        int rowDiff = r1 - r2;
        int columnDiff = c1 - c2;

        return rowDiff * rowDiff +
               columnDiff * columnDiff;
    }

    static boolean isValid(int r, int c) {
        return r >= 1 &&
               r <= N &&
               c >= 1 &&
               c <= N;
    }
}