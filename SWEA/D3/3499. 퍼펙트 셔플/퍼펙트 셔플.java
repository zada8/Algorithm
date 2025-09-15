import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            String[] cards = new String[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = st.nextToken();
            }

            sb.append("#").append(tc).append(" ");
            
            // 첫 번째 절반의 크기 계산 (홀수일 때 하나 더 많음)
            int firstHalfSize = (N + 1) / 2;
            int secondHalfStart = firstHalfSize;
            
            // 두 번째 절반의 크기만큼 번갈아가며 추가
            for (int i = 0; i < N / 2; i++) {
                sb.append(cards[i]).append(" ");
                sb.append(cards[secondHalfStart + i]).append(" ");
            }
            
            // N이 홀수인 경우, 첫 번째 절반의 마지막 카드 추가
            if (N % 2 == 1) {
                sb.append(cards[N / 2]).append(" ");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}