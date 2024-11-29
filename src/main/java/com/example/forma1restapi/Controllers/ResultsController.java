package com.example.forma1restapi.Controllers;

import com.example.forma1restapi.Models.Result;
import com.example.forma1restapi.Repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultsController {
    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/results")
    public List<Result> getAllResults(){
        List<Result> results = resultRepository.findAll();

        return results;
    }
}
