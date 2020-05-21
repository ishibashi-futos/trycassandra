package com.github.bash.trycassandra.trycassandra.controller;

import com.github.bash.trycassandra.trycassandra.dao.BooksModel;
import com.github.bash.trycassandra.trycassandra.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
  private final BooksService service;
  public BooksController(final BooksService service) {
    this.service = service;
  }

  @GetMapping("/")
  public ResponseEntity<List<BooksModel>> index() {
    return new ResponseEntity<>(this.service.getAllBooks(), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity create(@RequestBody BooksModel model) {
    service.addBook(model);
    return new ResponseEntity(HttpStatus.CREATED);
  }
}
