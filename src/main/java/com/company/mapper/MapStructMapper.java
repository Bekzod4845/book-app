package com.company.mapper;

import com.company.dto.BookDTO;
import com.company.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    BookDTO bookEntityToBookDTO(BookEntity bookEntity);


    BookEntity bookDTOToBookEntity(BookDTO bookDTO);

    BookEntity bookDTOToBookUpdate(BookDTO bookDTO,BookEntity bookEntity);

}
