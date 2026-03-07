package list;

import java.util.ArrayList;
import java.util.List;

public class List01_ArrayList {
	public static void main(String[] args) {
		//List: 순서 O / 중복 O
		ArrayList<String> names1 = new ArrayList<String>();
		List<String> names2 = new ArrayList<>();
		
		
		names2.add("도영훈");
		names2.add("천창현");
		names2.add("이정헌");
		names2.add(1, "이온유");
		
		for(String name: names2) {
			System.out.println(name);
		}
		System.out.println("------------------------");
		
		for(int i = 0 ; i<names2.size(); i++) {
			System.out.println(names2.get(i));
		}
		System.out.println("--------------------------");
		System.out.println(names2);
		
		//names2를 전부 비우고 싶다. -> 졸업시키겠다.
		//1. 인스턴스를 새로 만든다. (새로운 기수를 받는다)
//		names2 = new ArrayList<>();	
		//2. 전체를 반복 돌면서 하나씩 제거
//		for(int i = names2.size()-1 ; i>=0; i--) {
//			names2.remove(i);
//		}
		//3. clear()
		names2.clear();
		
		System.out.println(names2);
		
//		names2.set(0, "양");
		
		System.out.println(names2.isEmpty());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}	
