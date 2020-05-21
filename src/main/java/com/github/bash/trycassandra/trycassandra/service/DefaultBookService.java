package com.github.bash.trycassandra.trycassandra.service;

import com.github.bash.trycassandra.trycassandra.dao.BooksDao;
import com.github.bash.trycassandra.trycassandra.dao.BooksModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultBookService implements BooksService {
  private final BooksDao dao;
  public DefaultBookService(final BooksDao dao) {
    this.dao = dao;
  }

  @Override
  public List<BooksModel> getAllBooks() {
    var result = dao.getAll();
    dao.close();
    return result;
  }

  @Override
  public void addBook(BooksModel books) {
    dao.insert(books);
  }
}
