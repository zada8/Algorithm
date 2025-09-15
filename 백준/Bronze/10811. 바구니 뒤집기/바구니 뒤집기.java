import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	static int N,M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		//-------여기에 해결 코드를 작성하세요.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = i+1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken())-1;
			
			swap(numbers, l, r);
		}
		
		for (int num : numbers) {
			System.out.print(num+" ");
		}
	}

	private static void swap(int[] arr, int l, int r) {
		while(l < r) {
			int tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
		
		
		
	}

}
