import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] piece = {1, 1, 2, 2, 2, 8}; //올바른 피스 개수 배열
		int[] w_piece = new int[6]; //흰색 피스 배열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int j = 0; j <piece.length; j++) {      //흰색 피스 배열에 값 넣기
			w_piece[j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < piece.length; i++) {	
			if(piece[i] != w_piece[i]) {
				System.out.print(piece[i] - w_piece[i]+" ");
			}
			else {
				System.out.print(0+" ");
			}
		}
		
	}
}