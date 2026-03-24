package com.Carreira.GerenciadorDeLivros.controllers;

import com.Carreira.GerenciadorDeLivros.models.BookModel;
import com.Carreira.GerenciadorDeLivros.repositories.BookRepository;
import com.Carreira.GerenciadorDeLivros.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookModel>> findAllBook(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<BookModel> criarBook(@RequestBody BookModel bookModel){
        BookModel novo = bookService.criarBook(bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> buscarPorIdBook(@PathVariable Long id){
        Optional<BookModel> book = bookService.buscarPorId(id);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookModel> atualizarBook(@PathVariable Long id,
                                               @RequestBody BookModel bookModel){
        Optional<BookModel> existente = bookService.buscarPorId(id);

        if (existente.isPresent()) {
            BookModel atualizado = bookService.atualizar(id, bookModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBook (@PathVariable Long id){
        Optional<BookModel> existente = bookService.buscarPorId(id);

        if (existente.isPresent()) {
            bookService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
