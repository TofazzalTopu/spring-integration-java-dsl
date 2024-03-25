package com.springboot.integration.controller;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.gateway.ShopIntegrationGatewayJavaDsl;
import com.springboot.integration.model.Shop;
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
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopIntegrationGatewayJavaDsl shopIntegrationGatewayJavaDsl;

    @ApiOperation("Fetch shop by id")
    @GetMapping("/{id}")
    public ResponseEntity<Response<Shop>> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new Response<>(HttpStatus.OK.value(), AppConstants.RECORD_FETCHED_SUCCESSFULLY, shopIntegrationGatewayJavaDsl.findById(id)));
    }

    @ApiOperation("Create shop")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Shop>> create(@RequestBody @Valid Shop shop) throws URISyntaxException {
        return ResponseEntity.created(new URI("/integration/shop")).body(new Response<>(HttpStatus.CREATED.value(), AppConstants.RECORD_CREATED_SUCCESSFULLY, shopIntegrationGatewayJavaDsl.create(shop)));
    }

    @ApiOperation("Update shop")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Shop>> update(@PathVariable String id, @RequestBody @Valid Shop shop) {
        shop.setId(id);
        return ResponseEntity.accepted().body(new Response<>(HttpStatus.ACCEPTED.value(), AppConstants.RECORD_UPDATED_SUCCESSFULLY, shopIntegrationGatewayJavaDsl.update(shop)));
    }

    @ApiOperation("Delete shop")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(new Response<>(HttpStatus.NO_CONTENT.value(), AppConstants.RECORD_DELETED_SUCCESSFULLY, shopIntegrationGatewayJavaDsl.delete(id)));
    }
}
