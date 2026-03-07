package list;

import java.util.LinkedList;
import java.util.List;

public class List02_LinkedList {
	public static void main(String[] args) {
		//List: 순서 O / 중복 O
		List<String> names = new LinkedList<>();
		
		
		names.add("도영훈");
		names.add("천창현");
		names.add("이정헌");
		names.add("이정헌");
		names.add(1, "이온유");
		
		for(String name: names) {
			System.out.println(name);
		}
		System.out.println("------------------------");
		
		for(int i = 0 ; i<names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println("--------------------------");
		System.out.println(names);
		
		//names2를 전부 비우고 싶다. -> 졸업시키겠다.
		//1. 인스턴스를 새로 만든다. (새로운 기수를 받는다)
//		names2 = new ArrayList<>();	
		//2. 전체를 반복 돌면서 하나씩 제거
//		for(int i = names2.size()-1 ; i>=0; i--) {
//			names2.remove(i);
//		}
		//3. clear()
		names.clear();
		
		System.out.println(names);
		
//		names2.set(0, "양");
		
		System.out.println(names.isEmpty());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}	
