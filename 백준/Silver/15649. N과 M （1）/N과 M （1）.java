import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] nums;
	private static int[] pick;
	private static boolean[] v;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열
		//순서가 있음 -> 순열문제
		
		nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = i+1;
		}
		//1부터 N까지의 배열
		
		//v = new boolean[N]; //방문배열
		pick = new int[M];
		//선택한 수 저장할 배열
		v = new boolean[N]; //방문배열
		recursive(0);
	}
	
	public static void recursive(int cnt) {
		if(cnt==M) {
			for(int i = 0; i<M; i++) {
				System.out.print(pick[i]+" ");
			}
			System.out.println();
			
			
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!v[i]) {
				v[i]= true;
				pick[cnt] = nums[i];
				recursive(cnt+1);
				v[i]=false;
			}
		}
        
	}

}
