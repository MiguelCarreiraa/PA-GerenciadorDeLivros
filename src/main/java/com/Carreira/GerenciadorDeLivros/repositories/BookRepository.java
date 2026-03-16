package com.Carreira.GerenciadorDeLivros.repositories;

import com.Carreira.GerenciadorDeLivros.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookModel, Long> {
}
