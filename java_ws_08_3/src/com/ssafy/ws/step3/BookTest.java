package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {

		IBookManager manager = BookManagerImpl.getInstance();

		manager.add(new Book("1111", "자바", "홍길동", "멀티캠퍼스", 30000, "자바 기본"));
		manager.add(new Book("2222", "알고리즘", "김싸피", "싸피출판", 25000, "알고리즘 책"));

		manager.add(new Magazine("3333", "코딩월드", "이개발", "IT출판", 12000, "개발 잡지", 2024, 10));

		System.out.println("전체 목록");
		for (Book b : manager.getList()) {
			System.out.println(b);
		}

		System.out.println("\n잡지 목록");
		for (Magazine m : manager.getMagazines()) {
			System.out.println(m);
		}

		System.out.println("\n총 가격");
		System.out.println(manager.getTotalPrice());

		System.out.println("\n평균 가격");
		System.out.println(manager.getPriceAvg());
	}
}