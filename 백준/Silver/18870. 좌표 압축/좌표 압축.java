import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //좌표개수
		
		int[] arr = new int[N]; //입력받은 좌표들
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]); //중복x  
		}
		//정렬
		List<Integer> lst = new ArrayList<>(set);
		Collections.sort(lst);
		
		//값, 순서
		Map<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i<lst.size(); i++) {
			hm.put(lst.get(i), i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			sb.append(hm.get(arr[i])).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
