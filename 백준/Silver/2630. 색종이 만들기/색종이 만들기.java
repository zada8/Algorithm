
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}//색종이 완성
		
		divide(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void divide(int x, int y, int size) {
		if(isSame(x,y,size)) {
			if(board[y][x] == 0) white++;
			else blue++;
			return;
		}
		//4등분
		int newSize = size/2;
		divide(x,y,newSize);
		divide(x+newSize,y,newSize);
		divide(x,y+newSize, newSize);
		divide(x+newSize, y+newSize, newSize);
	}
	
	//색깔 같은지 확인
	static boolean isSame(int x, int y, int size) {
		int color = board[y][x];
		for(int i = y; i<y+size; i++) {
			for(int j = x; j<x+size; j++) {
				if(color != board[i][j]) return false;
			}
		}
		return true;
	}

}
