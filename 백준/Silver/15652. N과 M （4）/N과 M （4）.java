import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int M;
	public static int N;
	public static int[] nums;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		recursive(0,1);
		
		System.out.println(sb.toString());
		
	}
	
	public static void recursive(int depth, int num) {
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(nums[i]);
				if(i<M-1) sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num; i<=N; i++) {
			nums[depth] = i;
			recursive(depth+1, i);
		}
	}

}
