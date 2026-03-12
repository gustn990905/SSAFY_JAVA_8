package com.ssafy.ws.step4;

public class RestaurantTest {

	public static void main(String[] args) {

		IRestaurantManager manager = RestaurantManagerImpl.getInstance();

		manager.addRestaurant(new Restaurant(1, "맥도날드", "서울", "버거", 4));
		manager.addRestaurant(new KoreanRestaurant(2, "한식집", "부산", "비빔밥", 5, "051-1234", "15:00~17:00"));

		System.out.println("전체 식당");
		for (Restaurant r : manager.getRestaurantList()) {
			System.out.println(r);
		}

		System.out.println("\n한식 식당");
		for (KoreanRestaurant r : manager.getKoreanRestaurants()) {
			System.out.println(r);
		}

		IReviewManager reviewManager = manager.getReviewManager(1);

		reviewManager.addReview(new Review(1, 1, "홍길동", "맛있어요"));
		reviewManager.addReview(new Review(2, 1, "김철수", "좋아요"));

		System.out.println("\n리뷰 목록");
		for (Review r : reviewManager.getReviewList()) {
			System.out.println(r);
		}
	}
}