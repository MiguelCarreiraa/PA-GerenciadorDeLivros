package com.Carreira.GerenciadorDeLivros.controllers;

import com.Carreira.GerenciadorDeLivros.models.BookModel;
import com.Carreira.GerenciadorDeLivros.repositories.BookRepository;
import com.Carreira.GerenciadorDeLivros.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookModel>> findAll(){
        List<BookModel> requeste = bookService.findAll();
        return  ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<BookModel> criarBook(@RequestBody BookModel bookModel){
        return ResponseEntity.status(204).body(bookModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarBook (@PathVariable Long id){
        bookService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
