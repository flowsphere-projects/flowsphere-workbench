package com.flowsphere.server.controller;

import com.flowsphere.server.request.ConsumerRequest;
import com.flowsphere.server.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ConsumerRequest request){
        consumerService.save(request);
        return ResponseEntity.ok().build();
    }

}
