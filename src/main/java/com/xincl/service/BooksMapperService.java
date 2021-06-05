package com.xincl.service;

import com.xincl.mapper.BooksMapper;
import com.xincl.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BooksMapperService {
    //查询所有内容
    public List<Books> getAllBook();

    public Books getBooksById(@Param("bookID") int id);

    public int insert(Books books);

    public int update(Books books);

    public int delete(@Param("bookID")int id);
}
