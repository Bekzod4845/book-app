package com.company.controller;


import com.company.dto.BookDTO;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping ("/create")
    public ResponseEntity<?> create(@RequestBody BookDTO dto) {
     BookDTO bookDTO =   bookService.create(dto);

     return ResponseEntity.ok(bookDTO);
    }

    @GetMapping ("/list")
    public ResponseEntity<?> list() {
        List<BookDTO> bookDTOList =   bookService.list();
        return ResponseEntity.ok(bookDTOList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id , @RequestBody BookDTO dto){
        bookService.update(id,dto);
        return ResponseEntity.ok().body("successful update book");
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        bookService.delete(id);
        return ResponseEntity.ok().body("successful delete book");
    }
}
