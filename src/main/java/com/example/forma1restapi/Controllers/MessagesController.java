package com.example.forma1restapi.Controllers;

import com.example.forma1restapi.Models.Message;
import com.example.forma1restapi.Repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    @Autowired
    MessagesRepository messagesRepository;

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages(){
        List<Message> messages = messagesRepository.findAll();
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/messages")
    public ResponseEntity<?> addMessage(@RequestBody Message messageBody){
        if(messageBody.getDatum() == null){
            messageBody.setDatum(LocalDateTime.now());
        }

        Message message = messagesRepository.save(messageBody);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Message added.");

        return ResponseEntity.ok(response);
    }
}
