package com.xincl.mapper;

import com.xincl.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BooksMapper {

    //查询所有内容
    public List<Books> getAllBook();

    public Books getBooksById(@Param("bookID") int id);

    public int insert(Books books);

    public int update(Books books);

    public int delete(@Param("bookID") int id);

    int inserts(@Param("id") String id);


}
