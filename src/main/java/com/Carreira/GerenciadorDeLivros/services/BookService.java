package com.Carreira.GerenciadorDeLivros.services;

import com.Carreira.GerenciadorDeLivros.models.BookModel;
import com.Carreira.GerenciadorDeLivros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findAll(){return bookRepository.findAll();}

    public  BookModel criarBook(BookModel bookModel){return bookRepository.save(bookModel);}

    public Optional<BookModel> buscarPorId(Long id){return bookRepository.findById(id);}

    public BookModel atualizar(Long id, BookModel bookModel){
        BookModel model = bookRepository.findById(id).get();
        model.setAutor(bookModel.getAutor());
        model.setTitulo(bookModel.getTitulo());
        model.setAnoPublicacao(bookModel.getAnoPublicacao());
        return  bookRepository.save(model);
    }

    public void deletar(Long id){
        bookRepository.deleteById(id);
    }

}
