package com.ssafy.ws.step3;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	public Book() {}
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	// 객체의 정보를 리턴하는 toString 함수
	public static String toString(Book book) {
		return String.format("%-8s| %-12s| %-5s| %-12s| %-6d | %-12s",book.isbn,book.title,book.author,book.publisher,book.price,book.desc);
	}
	
	//아래와 같이 구현도 가능
//	public String toString2() {
//		return String.format("%-8s| %-12s| %-5s| %-12s| %-6d | %-12s",this.isbn,this.title,this.author,this.publisher,this.price,this.desc);
//	}
}
