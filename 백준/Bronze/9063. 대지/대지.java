
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class point{
		int x;
		int y;
		
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //점 개수
		point[] p = new point[N];
		
		for(int i = 0; i<N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new point(x,y);
		}
		int minX= Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE ;
		int minY=Integer.MAX_VALUE ;
		int maxY = Integer.MIN_VALUE;
		
		for(int i = 0; i<N; i++) {
			minX = Math.min(minX, p[i].x);
			minY = Math.min(minY, p[i].y);
			maxX = Math.max(maxX, p[i].x);
			maxY = Math.max(maxY, p[i].y);
			
		}
		
		System.out.println((maxX-minX)*(maxY-minY));
		
	}

}
