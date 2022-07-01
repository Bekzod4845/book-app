package com.company.mapper;

import com.company.dto.BookDTO;
import com.company.entity.BookEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-07-13T14:45:56+0200",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public BookDTO bookEntityToBookDTO(BookEntity bookEntity) {
        if (bookEntity == null){
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookEntity.getId());
        bookDTO.setTitle(bookEntity.getTitle());
        bookDTO.setAuthor(bookEntity.getAuthor());
        bookDTO.setName(bookEntity.getName());

        return bookDTO;
    }



    @Override
    public BookEntity bookDTOToBookEntity(BookDTO bookDTO) {
       if (bookDTO == null){
           return null;
       }
       BookEntity bookEntity = new BookEntity();
       bookEntity.setName(bookDTO.getName());
       bookEntity.setTitle(bookDTO.getTitle());
       bookEntity.setAuthor(bookDTO.getAuthor());
        return bookEntity;
    }

    @Override
    public BookEntity bookDTOToBookUpdate(BookDTO bookDTO, BookEntity bookEntity) {
        if (bookDTO == null){
            return null;
        }
        if (bookEntity == null){
            return null;
        }
        bookEntity.setName(bookDTO.getName());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        return bookEntity;
    }


}
