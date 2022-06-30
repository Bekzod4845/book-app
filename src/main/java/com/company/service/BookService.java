package com.company.service;

import com.company.dto.BookDTO;
import com.company.entity.BookEntity;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public BookDTO create(BookDTO dto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(dto.getName());
        bookEntity.setAuthor(dto.getAuthor());
        bookEntity.setTitle(dto.getTitle());
        bookRepository.save(bookEntity);
        dto.setId(bookEntity.getId());
        return dto;
    }

    public List<BookDTO> list() {
        Iterable<BookEntity> all = bookRepository.findAll();
        List<BookDTO>bookDTOList = new ArrayList<>();
        all.forEach(bookEntity -> {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setName(bookEntity.getName());
            bookDTO.setAuthor(bookEntity.getAuthor());
            bookDTO.setTitle(bookEntity.getTitle());
            bookDTOList.add(bookDTO);
        });
        return bookDTOList;
    }

    public void update(Integer id, BookDTO dto) {
        Optional<BookEntity> optional = bookRepository.findById(id);
        if (!optional.isPresent()){
            throw  new RuntimeException("not fount book");
        }
        BookEntity bookEntity = optional.get();
        bookEntity.setName(dto.getName());
        bookEntity.setAuthor(dto.getAuthor());
        bookEntity.setTitle(dto.getTitle());
        bookRepository.save(bookEntity);

    }
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
