package com.github.bash.trycassandra.trycassandra.service;

import com.github.bash.trycassandra.trycassandra.dao.BooksModel;

import java.awt.print.Book;
import java.util.List;

public interface BooksService {
  List<BooksModel> getAllBooks();

  void addBook(BooksModel books);
}
