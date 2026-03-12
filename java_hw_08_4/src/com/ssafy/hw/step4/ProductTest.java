package com.ssafy.hw.step4;

import java.util.List;

public class ProductTest {

	public static void main(String[] args) {

        IProductManager manager = ProductManagerImpl.getInstance();

        System.out.println("====== 상품 추가 ======");

        manager.addProduct(new Product("P1", "TV", 1500, 10, "Samsung", "Smart TV"));
        manager.addProduct(new Product("P2", "Laptop", 2000, 5, "LG", "Gaming Laptop"));

        manager.addProduct(new Refrigerator(
                "R1", "냉장고A", 3000, 3, "LG", "양문형 냉장고",
                "양문형", 600, true, 2024));

        manager.addProduct(new Refrigerator(
                "R2", "냉장고B", 2500, 2, "Samsung", "일반 냉장고",
                "일반형", 400, false, 2023));


        System.out.println("\n====== 전체 상품 목록 ======");
        for(Product p : manager.getProductList()){
            System.out.println(p);
        }


        System.out.println("\n====== 상품 코드 검색 ======");
        System.out.println(manager.searchByCode("P1"));


        System.out.println("\n====== 이름 검색 (냉장고) ======");
        for(Product p : manager.searchByName("냉장고")){
            System.out.println(p);
        }


        System.out.println("\n====== 상품 수정 ======");
        manager.updateProduct(new Product("P1", "TV", 1800, 8, "Samsung", "Updated Smart TV"));
        System.out.println(manager.searchByCode("P1"));


        System.out.println("\n====== 상품 판매 ======");
        int remain = manager.sell("P1", 3);
        System.out.println("남은 수량: " + remain);


        System.out.println("\n====== 냉장고 목록 ======");
        for(Refrigerator r : manager.getRefrigerators()){
            System.out.println(r);
        }


        System.out.println("\n====== 냉동 기능 있는 냉장고 ======");
        for(Refrigerator r : manager.getRefrigeratorsFreezer(true)){
            System.out.println(r);
        }


        System.out.println("\n====== 리뷰 추가 ======");

        manager.addReview(new Review(0, "P1", "홍길동", "정말 좋아요"));
        manager.addReview(new Review(0, "P1", "김철수", "가성비 좋음"));
        manager.addReview(new Review(0, "R1", "이영희", "냉장고 성능 좋음"));


        System.out.println("\n====== P1 상품 리뷰 ======");

        List<Review> reviews = manager.getProductReview("P1");

        for(Review r : reviews){
            System.out.println(r);
        }


        System.out.println("\n====== 총 재고 가격 ======");
        System.out.println(manager.getTotalPrice());


        System.out.println("\n====== 상품 삭제 ======");
        manager.removeProduct("P2");

        for(Product p : manager.getProductList()){
            System.out.println(p);
        }


        System.out.println("\n====== 테스트 종료 ======");
    }
}
