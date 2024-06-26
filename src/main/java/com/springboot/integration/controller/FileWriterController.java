package com.springboot.integration.controller;

import com.springboot.integration.response.Response;
import com.springboot.integration.service.fileWriter.FlatFileWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/write")
public class FileWriterController {

    @Autowired
    private FlatFileWriterService flatFileWriterService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> write() throws Exception {
        flatFileWriterService.write();
        return ResponseEntity.ok().body(new Response<>(HttpStatus.OK.value(), "FILE_WRITTEN_SUCCESSFULLY", "Success"));
    }


}
