package com.tsiry.project.controller;


import com.tsiry.project.Service.Receiver;
import com.tsiry.project.Service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sender")
public class SenderController {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/sendTopic/{name}")
    public String senHelloTo(@PathVariable String name) {
        sender.send(name);
        return "Hello " + name;
    }

    @PostMapping(path = "/sendTopic", consumes = "application/json", produces = "application/json")
    public String sendTopic(@RequestBody String message) {
        return null;
    }
}
