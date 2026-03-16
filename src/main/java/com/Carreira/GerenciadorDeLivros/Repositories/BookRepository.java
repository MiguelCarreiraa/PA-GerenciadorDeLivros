package com.Carreira.GerenciadorDeLivros.Repositories;

import com.Carreira.GerenciadorDeLivros.Models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookModel, Long> {
}
