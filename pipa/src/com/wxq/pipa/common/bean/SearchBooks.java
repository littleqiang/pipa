package com.wxq.pipa.common.bean;

import java.io.Serializable;
import java.util.LinkedList;

public class SearchBooks implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int start;
  private int count;
  private int total;
  private LinkedList<BookInfo> books;
  public int getStart() {
    return start;
  }
  public void setStart(int start) {
    this.start = start;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public LinkedList<BookInfo> getBooks() {
    return books;
  }
  public void setBooks(LinkedList<BookInfo> books) {
    this.books = books;
  }
  
}
