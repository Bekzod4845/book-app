package com.company.service;

import com.company.dto.BookDTO;
import com.company.entity.BookEntity;
import com.company.exceptions.UpdateBookException;
import com.company.mapper.MapStructMapper;
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

    @Autowired
    private MapStructMapper mapper;
    public void create(BookDTO dto) {
        bookRepository.save(mapper.bookDTOToBookEntity(dto));

    }

    public List<BookDTO> list() {
        Iterable<BookEntity> all = bookRepository.findAll();
        List<BookDTO>bookDTOList = new ArrayList<>();
        all.forEach(bookEntity -> {
            bookDTOList.add(mapper.bookEntityToBookDTO(bookEntity));
        });
        return bookDTOList;
    }

    public void update(Integer id, BookDTO dto) {
        Optional<BookEntity> optional = bookRepository.findById(id);
        if (!optional.isPresent()){
            throw  new UpdateBookException("not fount book");
        }
         BookEntity bookEntity = optional.get();
         bookRepository.save(mapper.bookDTOToBookUpdate(dto,bookEntity));

    }
    public void delete(Integer id) {
        Optional<BookEntity> optional = bookRepository.findById(id);
        if (!optional.isPresent()){
            throw  new UpdateBookException("not fount book");
        }
        bookRepository.deleteById(id);
    }
}
