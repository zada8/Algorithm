
import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			return b-a;
		});
		int max = 0;
		for(int i = 0; i<N; i++) {
			int in = Integer.parseInt(br.readLine());
			if(in == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else {
					max = pq.poll();
					System.out.println(max);
				
				}
			}
			else {
				pq.offer(in);
			}
		}
	}

}
