package com.github.bash.trycassandra.trycassandra.dao;

import com.github.bash.trycassandra.trycassandra.fw.CassandraDao;
import com.github.bash.trycassandra.trycassandra.fw.ConnectionConfig;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BooksDao extends CassandraDao {
  public BooksDao(final ConnectionConfig connectionConfig) {
    super(connectionConfig.getCqlSession());
  }

  public List<BooksModel> getAll() {
    return session.execute("SELECT * FROM books")
      .all().parallelStream().map(row -> new BooksModel(row.getString("isbn13"),
      row.getInt("price"),
      row.getLocalDate("date"),
      row.getString("title"))).collect(Collectors.toList());
  }

  public void insert(BooksModel model) {
    var stmt = session.prepare("INSERT INTO BOOKS(isbn13, date, price, title) values (?, ?, ?, ?)")
      .bind(model.isbn13, model.publishDate, model.price, model.title);
    session.execute(stmt);
  }
}
