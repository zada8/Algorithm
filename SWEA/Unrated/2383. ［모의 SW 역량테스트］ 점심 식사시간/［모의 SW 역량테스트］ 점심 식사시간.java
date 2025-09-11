import java.io.*;
import java.util.*;

public class Solution {
	static class Person implements Comparable<Person>{
		int x,y,dist, stair;
		Person(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
	}
	static List<Person> person;
	static Person stair1;
	static Person stair2;
	static int cAns = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); //방의 한 변의 길이
			int[][] room = new int[N][N];
			
			person = new ArrayList<>();
			stair1 = null;
			stair2 = null;
			
		
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					if(room[i][j] > 1 ) { //계단 발견
						if(stair1 == null) {
							stair1 = new Person(j, i, room[i][j]);
						}
						else {
							stair2 = new Person(j,i,room[i][j]);
						}
					}
					if(room[i][j] == 1) {
						person.add(new Person(j,i,0));
					}
				}
			}
			cAns = Integer.MAX_VALUE;
			combination(0);
		
			System.out.println("#"+t+" "+cAns);
			
		}
	}
	
	//조합
	static void combination(int idx) {
		if(idx == person.size()) {
			cAns = Math.min(simulation(), cAns);
			return;
		}
		person.get(idx).stair = 1;
		combination(idx+1);
		
		person.get(idx).stair = 2;
		combination(idx+1);
	}

	private static int simulation() {
		List<Person> stair1people = new ArrayList<>();
		List<Person> stair2people = new ArrayList<>();
		
		for(int i = 0; i<person.size(); i++) {
			if(person.get(i).stair == 1) {
				person.get(i).dist = Math.abs(stair1.x - person.get(i).x) + Math.abs(stair1.y - person.get(i).y);
				stair1people.add(person.get(i));
				
			}
			else {
				person.get(i).dist = Math.abs(stair2.x - person.get(i).x) + Math.abs(stair2.y - person.get(i).y);
				stair2people.add(person.get(i));
				
			}
		}
		Collections.sort(stair1people);
		Collections.sort(stair2people);
		
		int a = stairSimulation(stair1people, stair1.dist);
		int b = stairSimulation(stair2people, stair2.dist);
		int ans = Math.max(a, b);
		return ans;
		
	}
	
	static int stairSimulation(List<Person> people, int stairLength) {
		if(people.isEmpty()) return 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); //계단 이용중인 사람들의 완료시간
		int time = 1;
		int idx = 0; //다음에 들어갈 사람 인덱스
		
		while(true) {
			//계단에서 나가는 사람 확인
			while(!pq.isEmpty() && pq.peek() == time) {
				pq.poll();
			}
			//새로 들어올 수 있는 사람 확인
			while(idx< people.size() && people.get(idx).dist < time && pq.size() <3) {
				pq.offer(time + stairLength);
				idx++;
			}
			
			if(idx >= people.size() && pq.isEmpty()) {
				return time;
			}
			time++;
		}
	}
	
	
	
	
	
	
	
	
	
	

}
