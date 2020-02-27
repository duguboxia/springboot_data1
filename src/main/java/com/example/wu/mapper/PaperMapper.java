package com.example.wu.mapper;

import com.example.wu.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
//两个注解表示mapper的dao层
public interface PaperMapper {
    List<Paper> queryAll();

    Paper queryById(int id);

    int addPaper(Paper paper);

    int deletePaper(int id);

    int updatePaper(Paper paper);

}
