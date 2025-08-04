
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	private static int N;
	private static int[] arr;
	private static int M;
	private static int max = 0;
	private int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		recursive(0,0,0);
		System.out.println(max);
		
	}
	
	public static void recursive(int idx, int cnt, int sum) {//cnt:골랐는지 cnt
		if(cnt == 3) {
			
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			return ;
		
		}
		if(idx == N) {
			return;
		}
		//더하는 경우
		recursive(idx+1, cnt+1, sum+arr[idx]);
		//안 더하는 경우
		recursive(idx+1,cnt, sum);
		
		return;
	}

}
