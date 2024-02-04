package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    @Id
    private String id;
    private String name;
	private String author;
	private String publisher;
	private int unitPrice;
	private int availQuantity;
	
	public Book() {
		
	}

    public Book(String id, String name, String author, String publisher, int unitPrice, int availQuantity) {
    	this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.unitPrice = unitPrice;
        this.availQuantity = availQuantity;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAvailQuantity() {
		return availQuantity;
	}

	public void setAvailQuantity(int availQuantity) {
		this.availQuantity = availQuantity;
	}
    

}
