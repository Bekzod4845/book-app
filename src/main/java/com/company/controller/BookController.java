package com.company.controller;


import com.company.common.ApiResponse;
import com.company.dto.BookDTO;
import com.company.mapper.MapStructMapper;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping ("/create")
    public ResponseEntity<?> create(@RequestBody BookDTO dto) {
      bookService.create(dto);
     return new ResponseEntity<>(new ApiResponse(true,"book aded"),HttpStatus.CREATED);
    }

    @GetMapping ("/list")
    public ResponseEntity<?> list() {
        List<BookDTO> bookDTOList =   bookService.list();
        return new ResponseEntity<List<BookDTO>>(bookDTOList,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Integer id , @RequestBody BookDTO dto){
        bookService.update(id,dto);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "book updated"), HttpStatus.OK);

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Integer id){
        bookService.delete(id);
        return new ResponseEntity<>(new ApiResponse(true,"delete book"),HttpStatus.OK);
    }
}
