package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {

	private List<Book> books = new ArrayList<>();

	private static IBookManager instance = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static IBookManager getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		books.add(book);
	}

	@Override
	public void remove(String isbn) {

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
	}

	@Override
	public Book[] getList() {

		Book[] res = new Book[books.size()];
		return books.toArray(res);
	}

	@Override
	public Book searchByIsbn(String isbn) {

		for (Book b : books) {
			if (b.getIsbn().equals(isbn))
				return b;
		}

		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {

		List<Book> list = new ArrayList<>();

		for (Book b : books) {
			if (b.getTitle().contains(title)) {
				list.add(b);
			}
		}

		Book[] res = new Book[list.size()];
		return list.toArray(res);
	}

	@Override
	public Magazine[] getMagazines() {

		List<Magazine> list = new ArrayList<>();

		for (Book b : books) {
			if (b instanceof Magazine) {
				list.add((Magazine) b);
			}
		}

		Magazine[] res = new Magazine[list.size()];
		return list.toArray(res);
	}

	@Override
	public Book[] getBooks() {

		List<Book> list = new ArrayList<>();

		for (Book b : books) {
			if (!(b instanceof Magazine)) {
				list.add(b);
			}
		}

		Book[] res = new Book[list.size()];
		return list.toArray(res);
	}

	@Override
	public int getTotalPrice() {

		int sum = 0;

		for (Book b : books) {
			sum += b.getPrice();
		}

		return sum;
	}

	@Override
	public double getPriceAvg() {

		int sum = getTotalPrice();
		return (double) sum / books.size();
	}
}