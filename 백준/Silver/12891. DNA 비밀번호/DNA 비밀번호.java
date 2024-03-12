import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class DNA {
    int a, c, g, t;

    public DNA(int a, int c, int g, int t) {
        this.a = a;
        this.c = c;
        this.g = g;
        this.t = t;
    }

    public void plus(char c) {
        switch (c) {
            case 'A': {
                this.a++;
                break;
            }
            case 'C': {
                this.c++;
                break;
            }
            case 'G': {
                this.g++;
                break;
            }
            case 'T': {
                this.t++;
                break;
            }
        }
    }

    public void minus(char c) {
        switch (c) {
            case 'A': {
                this.a--;
                break;
            }
            case 'C': {
                this.c--;
                break;
            }
            case 'G': {
                this.g--;
                break;
            }
            case 'T': {
                this.t--;
                break;
            }
        }
    }

    public boolean isValid(DNA dna) {
        return dna.a <= this.a && dna.c <= this.c && dna.g <= this.g && dna.t <= this.t;
    }
}
public class Main {
    static int S, P;
    static DNA baseDna;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        char[] inputArray = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        baseDna = new DNA(Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken()));

        // init by first string
        DNA dna = new DNA(0, 0, 0, 0);
        for (int i = 0; i < P; i++) {
            dna.plus(inputArray[i]);
        }

        int answer = dna.isValid(baseDna) ? 1 : 0;
        char prev = inputArray[0];
        int start = 1;
        int end = P;

        while (end < S) {
            dna.minus(prev);
            dna.plus(inputArray[end]);

            if (dna.isValid(baseDna)) {
                answer++;
            }

            prev = inputArray[start];
            start++;
            end++;
        }

        System.out.print(answer);
    }
}
