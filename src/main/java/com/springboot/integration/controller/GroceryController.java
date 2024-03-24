package com.springboot.integration.controller;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.gateway.GroceryIntegrationGatewayJavaDsl;
import com.springboot.integration.model.Grocery;
import com.springboot.integration.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;


@CrossOrigin
@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @Autowired
    private GroceryIntegrationGatewayJavaDsl groceryIntegrationGatewayJavaDSL;

    @ApiOperation("Fetch grocery by id")
    @GetMapping("/{id}")
    public ResponseEntity<Response<Grocery>> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new Response<>(HttpStatus.OK.value(), AppConstants.GROCERY_FETCHED_SUCCESSFULLY, groceryIntegrationGatewayJavaDSL.findById(id)));
    }

    @ApiOperation("Create grocery")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Grocery>> createGrocery(@RequestBody @Valid Grocery grocery) throws URISyntaxException {
        return ResponseEntity.created(new URI("/integration/grocery")).body(new Response<>(HttpStatus.CREATED.value(), AppConstants.GROCERY_CREATED_SUCCESSFULLY, groceryIntegrationGatewayJavaDSL.create(grocery)));
    }

    @ApiOperation("Update grocery")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Grocery>> updateGrocery(@RequestBody @Valid Grocery grocery) {
        return ResponseEntity.accepted().body(new Response<>(HttpStatus.ACCEPTED.value(), AppConstants.GROCERY_UPDATED_SUCCESSFULLY, groceryIntegrationGatewayJavaDSL.update(grocery)));
    }

    @ApiOperation("Delete grocery")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new Response<>(HttpStatus.NO_CONTENT.value(), AppConstants.GROCERY_DELETED_SUCCESSFULLY, groceryIntegrationGatewayJavaDSL.delete(id)));
    }
}
