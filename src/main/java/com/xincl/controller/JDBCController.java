package com.xincl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/all")
    public List<Map<String,Object>> getAll(){
        String sql = "select * from books";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }

    @GetMapping("/insert")
    public String insert(){
        String sql = "insert into books(bookID,bookName,bookCounts,detail) values(111,'xincl',99,'filghting')";
        jdbcTemplate.update(sql);
        return "insert ok";
    }

    @GetMapping("/update1/{id}")
    public String update(@PathVariable("id") int id){
        String sql = "update books set bookName=?,bookCounts=? where bookID="+id;
        Object[] objects = new Object[2];
        objects[0] = "小明自传";
        objects[1] = 101111;
        jdbcTemplate.update(sql,objects);
        return "update ok";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        String sql = "delete from books where bookID="+id;
        jdbcTemplate.update(sql);
        return "delete ok";
    }



}
