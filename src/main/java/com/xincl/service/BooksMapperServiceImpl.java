package com.xincl.service;

import com.xincl.mapper.BooksMapper;
import com.xincl.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksMapperServiceImpl implements BooksMapperService{
    @Autowired
    BooksMapper booksMapper;

    @Override
    public List<Books> getAllBook() {
//        System.out.println("11111");
        return booksMapper.getAllBook();
    }

    @Override
    public Books getBooksById(int id) {
        return booksMapper.getBooksById(id);
    }

    @Override
    public int insert(Books books) {
        return booksMapper.insert(books);
    }

    @Override
    public int update(Books books) {
        return booksMapper.update(books);
    }

    @Override
    public int delete(int id) {
        return booksMapper.delete(id);
    }
}
