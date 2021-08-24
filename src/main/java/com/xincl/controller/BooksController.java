package com.xincl.controller;

import com.xincl.mapper.BooksMapper;
import com.xincl.pojo.Books;
import com.xincl.service.BooksMapperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class BooksController {
    @Autowired
    private BooksMapperService booksMapperService;

    @RequestMapping("/mybatis/getAll")
    public List<Books> getAll() {
        List<Books> allBook = booksMapperService.getAllBook();
        for (Books books : allBook) {
            System.out.println(books);
        }
        return allBook;
    }

    @GetMapping("/mybatis/getById/{id}")
    public String getBoookById(@PathVariable int id) {
        Books booksById = booksMapperService.getBooksById(id);
        return booksById.toString();
    }

    @RequestMapping("/mybatis/insert")
    public String insert1() {
        booksMapperService.insert(new Books(8, "java", 999, "面向发家致富编程"));
        return "insert yes";
    }

    @RequestMapping("/mybatis/update")
    public String update1() {
        booksMapperService.insert(new Books(6, "java222", 9991, "面向发家致富编程"));
        return "update ok";
    }

    @RequestMapping("/mybatis/delete/{id}")
    public String delete1(@PathVariable int id) {
        booksMapperService.delete(id);
        return "delete yes";
    }

    @RequestMapping("/test/111")
    public String test() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        int i = c.get(Calendar.DAY_OF_WEEK) - 1;
        int sum = 9;
        String s = null;
        if (sum > 3) {
            s = "1";
        } else if (sum > 6) {
            s = "2";
        }
        return s;
    }

    @RequestMapping("/test/map")
    public String test1() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1111");
        map.put("2", "22222");
        String s = map.get("1");
        map.put("1", "3333");
        String s1 = map.get("1");
        return s + "-----" + s1;
    }

    @RequestMapping("/open/111.do")
    public String test2() {
        String s = "123JXqwe";
        if(s.contains("JX")){
            System.out.println("yes");
            return "yes";
        }else {
            return "no";
        }
    }

    @RequestMapping("/insert111")
    public String test03(){
        for (int i=0;i<970;i++){
            String s = UUID.randomUUID() + "";
            String s1 = s.replaceAll("-","");
            booksMapperService.inserts(s1);
        }
        return "yes";
    }

    @RequestMapping("/n!/{n}")
    public String test_n(@PathVariable int n){
//        String result = test(n)+"";
        String result1 = test02_1(n)+"";
        return result1;
    }


    public int test(int n){
        if(n<=1){
            return n=1;
        }else {
            int i = n * test(n - 1);
            System.out.println(i);
            return i;
        }
    }

    public int test02_1(int n){
        int sum=1;
//        File file = new File("");
//        File[] files = file.listFiles();

        if(n==0){
            return sum;
        }else {
            for (int i = 1; i <= n; i++) {
                sum = sum*i;
            }
            return sum;
        }
    }

    @RequestMapping("/px")
    public String testPX(){
        int[] a = {5,2,4,3,1};
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-i-1;j++){
                int temp = a[j];
                if(temp>a[j+1]){
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println();
        return Arrays.toString(a);
    }


}
