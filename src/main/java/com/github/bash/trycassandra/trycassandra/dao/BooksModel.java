package com.github.bash.trycassandra.trycassandra.dao;

import java.time.LocalDate;

public class BooksModel {
  public final String isbn13;
  public final int price;
  public final LocalDate publishDate;
  public final String title;

  public BooksModel(final String isbn13,
                    final int price,
                    final LocalDate publishDate,
                    final String title) {
    this.isbn13 = isbn13;
    this.price = price;
    this.publishDate = publishDate;
    this.title = title;
  }
}
