package com.ssafy.ws.step5;

import java.util.List;

public class BoardTest {

	static IArticleManager am = ArticleManagerImpl.getInstance();
	static IUserManager um = UserManagerImpl.getInstance();

	public static void main(String[] args) {

		um.signup(new User(1, "admin", "1234", "관리자", "admin", "admin@test.com"));
		um.login("admin", "1234");

		am.addArticle(new Article(1, "첫 글", "게시판 시작", 1));
		am.addArticle(new ImageArticle(2, "이미지 글", "이미지 포함", 1, "test.jpg", 800, 600));

		System.out.println("===== 전체 글 =====");
		for (Article a : am.getArticleList())
			System.out.println(a);

		System.out.println("===== 이미지 글 =====");
		for (ImageArticle a : am.getImageArticleList())
			System.out.println(a);

		System.out.println("===== 이미지 평균 크기 =====");
		System.out.println(am.getImageSizeAvg());

		am.addComment(new Comment(1, 1, 1, "댓글입니다"));

		List<Comment> comments = am.getCommentList(1);

		System.out.println("===== 댓글 =====");
		for (Comment c : comments)
			System.out.println(c);
	}
}