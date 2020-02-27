package com.example.wu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class jdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
       //查询数据库的所有信息
        //没有实体类的封装，如何查询？ map
    @RequestMapping("/query")
    public List<Map<String,Object>> paperList(){
        String sql="select * from paper";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }
    @RequestMapping("/add")
    public String add(){
        String sql="insert into paper(name,number,detail) values('语文',100,'测试')";
        jdbcTemplate.update(sql);
        return "add ok";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") int id){
        String sql="update paper set name=?,number=?,detail=?   where id="+id;

        //封装
        Object[] objects=new Object[3];
        objects[0]="数学";
        objects[1]=150;
        objects[2]="测试一下";
        jdbcTemplate.update(sql,objects);
        return "update ok";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        String sql="delete  from paper where id = ?";
        jdbcTemplate.update(sql,id);
        return "delete ok";
    }

}
