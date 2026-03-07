package com.ssafy.set;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Set04_TreeSet {
	public static void main(String[] args) {
//		Set<Integer>set =new TreeSet<>();
		NavigableSet<Integer> set = new TreeSet<>();
		// 이진탐색트리(BST)
		set.add(10);
		set.add(20);
		set.add(150);
		set.add(50);
		set.add(25);
		set.add(10);
		set.add(30);
		System.out.println(set); // 정렬이 된 상태로 나오는 군!

		System.out.println(set.first());
		System.out.println(set.last());

		// 근접탐색
		System.out.println(set.lower(30)); // 30 미만 이면서 가장 큰
		System.out.println(set.floor(30)); // 30 이하 이면서 가장 큰
		System.out.println(set.ceiling(30)); // 30 이상 이면서 가장 작은
		System.out.println(set.higher(30)); // 30 초과 이면서 가장 작은

		System.out.println(set.descendingSet());

		System.out.println(Arrays.toString(set.toArray()));

	}
}
