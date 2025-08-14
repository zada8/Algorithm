import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//중복 순열?

	private static int M;
	private static int N;
	private static int[] pick;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pick = new int[M];
		
		recursive(0);
		
		System.out.println(sb.toString());

	}
	
	public static void recursive(int depth) {
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(pick[i]);
				if(i<M-1) sb.append(" ");
			}
			sb.append("\n");
			return;
		}
	
		for(int i = 0; i<N; i++) {
			pick[depth] = i+1;
			recursive(depth+1);
			
		}
		
	}

}
