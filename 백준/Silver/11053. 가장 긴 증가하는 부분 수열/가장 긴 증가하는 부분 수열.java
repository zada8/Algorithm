
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = 1;
			for(int j = 0; j<i; j++) {
				if(A[j]<A[i]) {
					arr[i] = Math.max(arr[i], arr[j]+1);
				}
			}
		}
		int ans = 0;
		for(int i = 0; i<N; i++) {
			ans = Math.max(ans, arr[i]);
		}
		System.out.println(ans);
	}

}
