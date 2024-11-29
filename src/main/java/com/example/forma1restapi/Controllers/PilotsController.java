package com.example.forma1restapi.Controllers;

import com.example.forma1restapi.Models.Pilot;
import com.example.forma1restapi.Repositories.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pilots")
public class PilotsController {

    @Autowired
    PilotRepository pilotRepository;

    @GetMapping("/pilots")
    public List<Pilot> getAllPilots(){
        List<Pilot> pilots = pilotRepository.findAll();

        return pilots;
    }
}
