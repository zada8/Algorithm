import java.io.*;
import java.util.*;


public class Main {
	static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				board[i][j] = str.charAt(j)-48;
			}
		}//흑백영상 만들기
		
		divide(0,0,N);
	}
	static void divide(int x, int y, int size) {
		if(isSame(x,y,size)) {
			if(board[y][x] == 0) {
				System.out.print(0);
			}
			else {
				System.out.print(1);
			}
			return;
		}
		int newSize = size/2;
		System.out.print("(");
		divide(x,y,newSize);
		divide(x+newSize,y,newSize);
		divide(x,y+newSize,newSize);
		divide(x+newSize,y+newSize,newSize);
		System.out.print(")");
	}
	
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
