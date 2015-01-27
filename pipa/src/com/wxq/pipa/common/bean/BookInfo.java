/**
 * 
 */
package com.wxq.pipa.common.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * 描述:豆瓣图书信息
 */
public class BookInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String url;
	private String image;
	private String author;//作者
	private String translator;//翻译
	private String publisher;//出版公司
	private String pubdate;//出版时间
	private Rating rating;
	private Tags tags;
	private String binding;
	private String price;
	private Series series;
	private String pages;//总页数
	private String author_intro;//作者描述
	private String summary;//简介
	private String catalog;
	private String ebook_url;
	private String ebook_price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Tags getTags() {
		return tags;
	}
	public void setTags(Tags tags) {
		this.tags = tags;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getAuthor_intro() {
		return author_intro;
	}
	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getEbook_url() {
		return ebook_url;
	}
	public void setEbook_url(String ebook_url) {
		this.ebook_url = ebook_url;
	}
	public String getEbook_price() {
		return ebook_price;
	}
	public void setEbook_price(String ebook_price) {
		this.ebook_price = ebook_price;
	}
	

}
