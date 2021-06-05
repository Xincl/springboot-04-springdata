package com.xincl.controller;

import com.xincl.mapper.BooksMapper;
import com.xincl.pojo.Books;
import com.xincl.service.BooksMapperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BooksMapperService booksMapperService;

    @RequestMapping("/mybatis/getAll")
    public List<Books> getAll(){
        List<Books> allBook = booksMapperService.getAllBook();
        for (Books books : allBook) {
            System.out.println(books);
        }
        return allBook;
    }

    @GetMapping("/mybatis/getById/{id}")
    public String getBoookById(@PathVariable int id){
        Books booksById = booksMapperService.getBooksById(id);
        return booksById.toString();
    }

    @RequestMapping("/mybatis/insert")
    public String insert1(){
        booksMapperService.insert(new Books(8,"java",999,"面向发家致富编程"));
        return "insert yes";
    }

    @RequestMapping("/mybatis/update")
    public String update1(){
        booksMapperService.insert(new Books(6,"java222",9991,"面向发家致富编程"));
        return "update ok";
    }

    @RequestMapping("/mybatis/delete/{id}")
    public String delete1(@PathVariable int id){
        booksMapperService.delete(id);
        return "delete yes";
    }




}
