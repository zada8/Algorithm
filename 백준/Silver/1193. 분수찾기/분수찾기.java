
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int cnt = 1;
		int range = 2;
		if (X == 1 ) {
			
		}
		while (X >= range) {
			range = range + cnt + 1;  //range는 자기보다 한 칸 더 큰 수의 최소값에서 멈춤
			cnt++;
		}
		
		if(cnt%2 ==1) {//대각선 아래에서 위로
			int a = range - X;
			int b = cnt + 1 -a;
			System.out.println(a +"/"+ b);
			
		}
		else {
			int b = range - X;
			int a = cnt +1 - b;
			System.out.println(a +"/"+ b);
			
		}
		
	}

}
