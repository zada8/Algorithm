import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parents;
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //유적지의 개수
		int m = Integer.parseInt(st.nextToken()); //설치될 통로의 수
		
		parents = new int[n];
		for(int i = 0; i<n; i++) {
			parents[i] = i;
		}
		
		int ans = 0; //설치한 통로의 수
		boolean isCycle = false;
		int[] arr = new int[n]; //중복 확인용
		int[] arr2 = new int[n]; //중복 확인2
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(find(a) == find(b)) {//같으면 사이클 있는거임
				System.out.println(++ans);
				isCycle = true;
				break;
			}
			else {
				union(a,b);
				ans++;
			}
			
		}
		if(!isCycle) {
			System.out.println(0);
		}

		
	
		
	}
	
	//합치기
	static void union(int a, int b) {
		//if(find(a) == find(b)) return;
		int rootA = find(a);
		int rootB = find(b);
		parents[rootA] = rootB;
	}
	
	//대표값 찾기
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

}
