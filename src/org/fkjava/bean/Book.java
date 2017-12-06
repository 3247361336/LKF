package org.fkjava.bean;

import java.util.Date;

/**
 * CREATE TABLE `tb_book` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(54) default NULL,
  `author` varchar(54) default NULL,
  `publicationdate` date default NULL,
  `publication` varchar(150) default NULL,
  `price` double default NULL,
  `image` varchar(54) default NULL,
  `remark` varchar(600) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author Hello
 *
 */
public class Book {
	private Integer id;
	private String name;
	private String author;
	private Date publicationdate;
	private String publication;
	private Double price;
	private String image;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Date getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publicationdate=" + publicationdate
				+ ", publication=" + publication + ", price=" + price + ", image=" + image + ", remark=" + remark + "]";
	}
	
	
	
}
