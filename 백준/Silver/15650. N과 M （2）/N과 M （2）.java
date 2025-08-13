
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] nums;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		recursive(1, 0);
	}
	
	public static void recursive(int num, int cnt) {
		if(cnt ==M) {
			for(int i = 0; i<M; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = num; i <= N; i++) {
						
			nums[cnt]= i;
			recursive(i+1, cnt+1);
				

		}
		
	}


}
