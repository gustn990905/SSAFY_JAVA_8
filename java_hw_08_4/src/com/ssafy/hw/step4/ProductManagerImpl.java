package com.ssafy.hw.step4;

import java.util.*;

public class ProductManagerImpl implements IProductManager {

	private List<Product> products = new ArrayList<>();
	private Map<String, List<Review>> reviews = new HashMap<>();
	private int reviewNo = 1;

	private static IProductManager instance = new ProductManagerImpl();

	private ProductManagerImpl() {
	}

	public static IProductManager getInstance() {
		return instance;
	}

	@Override
	public boolean addProduct(Product product) {
		return products.add(product);
	}

	@Override
	public boolean updateProduct(Product product) {

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i).getpCode().equals(product.getpCode())) {
				products.set(i, product);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean removeProduct(String pCode) {

		return products.removeIf(p -> p.getpCode().equals(pCode));
	}

	@Override
	public int sell(String pCode, int cnt) {

		Product p = searchByCode(pCode);

		if (p == null)
			return -1;

		if (p.getQuantity() < cnt)
			return -1;

		p.setQuantity(p.getQuantity() - cnt);

		return p.getQuantity();
	}

	@Override
	public Product[] getProductList() {

		return products.toArray(new Product[0]);
	}

	@Override
	public Product searchByCode(String pCode) {

		for (Product p : products) {

			if (p.getpCode().equals(pCode))
				return p;
		}

		return null;
	}

	@Override
	public boolean addReview(Review review) {

		review.setReviewId(reviewNo++);

		reviews.putIfAbsent(review.getpCode(), new ArrayList<>());

		return reviews.get(review.getpCode()).add(review);
	}

	@Override
	public boolean removeReview(Review review) {

		List<Review> list = reviews.get(review.getpCode());

		if (list == null)
			return false;

		return list.remove(review);
	}

	@Override
	public List<Review> getProductReview(String pCode) {

		return reviews.getOrDefault(pCode, new ArrayList<>());
	}

	@Override
	public Product[] searchByName(String name) {

		List<Product> result = new ArrayList<>();

		for (Product p : products) {

			if (p.getpName().contains(name))
				result.add(p);
		}

		return result.toArray(new Product[0]);
	}

	@Override
	public long getTotalPrice() {

		long sum = 0;

		for (Product p : products) {

			sum += (long) p.getPrice() * p.getQuantity();
		}

		return sum;
	}

	@Override
	public Product[] getProducts() {

		return products.toArray(new Product[0]);
	}

	@Override
	public Refrigerator[] getRefrigerators() {

		List<Refrigerator> result = new ArrayList<>();

		for (Product p : products) {

			if (p instanceof Refrigerator)
				result.add((Refrigerator) p);
		}

		return result.toArray(new Refrigerator[0]);
	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {

		List<Refrigerator> result = new ArrayList<>();

		for (Product p : products) {

			if (p instanceof Refrigerator) {

				Refrigerator r = (Refrigerator) p;

				if (r.isFreezer() == freezer)
					result.add(r);
			}
		}

		return result.toArray(new Refrigerator[0]);
	}
}