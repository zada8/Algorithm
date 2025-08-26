import java.io.*;
import java.util.*;

public class Main {

	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); //연산의 개수
		
		parents = new int[n+1]; //0부터 n까지 n+1개 집합
		
		for(int i = 0; i<=n; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int cal = Integer.parseInt(st2.nextToken());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(cal == 0) {
				union(a,b);
			}
			else if(cal == 1) {
				if(find(a)== find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int ua = find(a);
		int ub = find(b);
		if(ua != ub) {
			parents[ub] = ua;
		}
	}

}
