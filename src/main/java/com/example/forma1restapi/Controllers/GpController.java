package com.example.forma1restapi.Controllers;

import com.example.forma1restapi.Models.Gp;
import com.example.forma1restapi.Repositories.GpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gp")
public class GpController {

    @Autowired
    GpRepository gpRepository;

    @GetMapping("/allgp")
    public List<Gp> getAllGp(){
        List<Gp> allGp = gpRepository.findAll();

        return allGp;
    }
}
