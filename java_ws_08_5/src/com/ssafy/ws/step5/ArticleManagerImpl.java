package com.ssafy.ws.step5;

import java.util.*;

public class ArticleManagerImpl implements IArticleManager {

	private List<Article> articles = new ArrayList<>();
	private Map<Integer, List<Comment>> comments = new HashMap<>();

	private static IArticleManager instance = new ArticleManagerImpl();

	private ArticleManagerImpl() {
	}

	public static IArticleManager getInstance() {
		return instance;
	}

	@Override
	public List<Article> getArticleList() {
		return articles;
	}

	@Override
	public Article getArticle(int articleId) {
		for (Article a : articles) {
			if (a.getArticleId() == articleId)
				return a;
		}
		return null;
	}

	@Override
	public void addArticle(Article article) {
		articles.add(article);
	}

	@Override
	public void removeArticle(int articleId) {
		articles.removeIf(a -> a.getArticleId() == articleId);
	}

	@Override
	public void updateArticle(Article article) {

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == article.getArticleId()) {
				articles.set(i, article);
				return;
			}
		}
	}

	@Override
	public List<Article> getTextArticleList() {

		List<Article> result = new ArrayList<>();

		for (Article a : articles)
			if (!(a instanceof ImageArticle))
				result.add(a);

		return result;
	}

	@Override
	public List<ImageArticle> getImageArticleList() {

		List<ImageArticle> result = new ArrayList<>();

		for (Article a : articles)
			if (a instanceof ImageArticle)
				result.add((ImageArticle) a);

		return result;
	}

	@Override
	public double getImageSizeAvg() {

		List<ImageArticle> imgs = getImageArticleList();

		if (imgs.isEmpty())
			return 0;

		double sum = 0;

		for (ImageArticle i : imgs)
			sum += i.getWidth() * i.getHeight();

		return sum / imgs.size();
	}

	@Override
	public List<Article> search(int option, String keyword) {

		List<Article> result = new ArrayList<>();

		for (Article a : articles) {

			if (option == 1 && a.getTitle().contains(keyword))
				result.add(a);

			if (option == 2 && a.getContent().contains(keyword))
				result.add(a);
		}

		return result;
	}

	@Override
	public void addComment(Comment comment) {

		comments.putIfAbsent(comment.getArticleId(), new ArrayList<>());

		comments.get(comment.getArticleId()).add(comment);
	}

	@Override
	public void removeComment(int articleId, int commentId) {

		List<Comment> list = comments.get(articleId);

		if (list == null)
			return;

		list.removeIf(c -> c.getCommentId() == commentId);
	}

	@Override
	public List<Comment> getCommentList(int articleId) {

		return comments.getOrDefault(articleId, new ArrayList<>());
	}
}