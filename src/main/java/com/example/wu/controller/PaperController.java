package com.example.wu.controller;

import com.example.wu.pojo.Paper;
import com.example.wu.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping("/queryPaper")
    public List<Paper> print(){
        List<Paper> paperList = paperService.queryAll();
       return paperList;
    }

}
