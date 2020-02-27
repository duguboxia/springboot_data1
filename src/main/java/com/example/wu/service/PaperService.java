package com.example.wu.service;

import com.example.wu.pojo.Paper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PaperService {
    List<Paper> queryAll();

    Paper queryById(int id);

    int addPaper(Paper paper);

    int deletePaper(int id);

    int updatePaper(Paper paper);
}
