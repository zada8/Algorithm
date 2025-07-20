import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //바구니 수
		int M = Integer.parseInt(st.nextToken()); //역순 만들 횟수
		
		int[] array = new int[N];
		
		for (int l = 0; l <N; l++) {
			array[l] = l+1;
		}
		
		for (int k = 0; k < M; k++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st2.nextToken()); //i번째부터 j번째까지 역순
			int j = Integer.parseInt(st2.nextToken());
			
			while (i < j) {
				int temp = array[i-1];
				array[i-1] = array[j-1];
				array[j-1] = temp;
				i++;
				j--;
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(array[i] +" ");
		}
		System.out.println();
		
	}

}
