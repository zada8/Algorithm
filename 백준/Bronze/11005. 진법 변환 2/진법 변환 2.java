
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //10진법 수 N
		int B = Integer.parseInt(st.nextToken()); //B진법으로 
		List<Integer> lst = new ArrayList<>();
		while(N >= B) {
			lst.add(N%B); 
			N /= B;
		}
		lst.add(N);
		Collections.reverse(lst);
		
		for (int i = 0; i<lst.size(); i++) {
			if(lst.get(i)>=10) {
				System.out.print((char)(lst.get(i)+'A'-10));
			}
			else {
				System.out.print(lst.get(i));
			}
		}
		
		
	}

}
