package com.example.xperttest.controller;

import com.example.xperttest.model.dto.Request;
import com.example.xperttest.service.SummationService;
import com.example.xperttest.model.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cube/calculator")
public class CubeController {

    private SummationService summationService;

    @Autowired
    public CubeController(SummationService summationService) {
        this.summationService = summationService;
    }

    @PostMapping("/process")
    public ResponseEntity<Response> processCube(@RequestBody Request request) {
        return new ResponseEntity<>(summationService.processCube(request),
                HttpStatus.OK);
    }
}
