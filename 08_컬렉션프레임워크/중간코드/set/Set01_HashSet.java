package set;

import java.util.HashSet;
import java.util.Set;

public class Set01_HashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		//추가
		set.add("서진주");
		set.add("도영훈");
		set.add(null);
		set.add("김민준");
		set.add("서진주");
		set.add("서진주");
		set.add(null);
		set.add("서진주");
		set.add(null);
		
		System.out.println(set);
		
		System.out.println(set.contains("서진주1"));
		
		//for-each
		
		System.out.println(set.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
