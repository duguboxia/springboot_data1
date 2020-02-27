package com.example.wu.service;

import com.example.wu.mapper.PaperMapper;
import com.example.wu.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaperServiceImp implements PaperService {
    @Autowired
    private PaperMapper mapper;

    @Override
    public List<Paper> queryAll() {
        System.out.println(mapper.queryAll());
        return mapper.queryAll();
    }

    @Override
    public Paper queryById(int id) {
        return mapper.queryById(id);
    }

    @Override
    public int addPaper(Paper paper) {
        return mapper.addPaper(paper);
    }

    @Override
    public int deletePaper(int id) {
        return mapper.deletePaper(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return mapper.updatePaper(paper);
    }
}
