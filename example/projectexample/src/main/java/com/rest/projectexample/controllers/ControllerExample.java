package com.rest.projectexample.controllers;

import com.rest.projectexample.services.ExamplleService;
import com.rest.projectexample.to.ExampleTO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping(value = "/project-example")
public class ControllerExample {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExample.class);
    
    @Autowired
    private ExamplleService examplleService;
    
    @ApiOperation(value = "Endpoints for Get project-example", nickname = "getProjectExampleGet")
    @RequestMapping(value = "/getProjectExampleGet/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProjectExampleGet(
            @PathVariable("key") String key,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "info", required = false) String info) {
        try {
            return new ResponseEntity<>(examplleService.fillExampleGet(key, name, info), HttpStatus.OK);
        } catch (RestClientException restClientException) {
            LOG.error("Error project-example getProjectExampleGet: {}", restClientException);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Endpoints for Post project-example", nickname = "getProjectExamplePost")
    @RequestMapping(value = "/getProjectExamplePost/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProjectExamplePost(@RequestBody ExampleTO exampleTO) {
        try {
            return new ResponseEntity<>(examplleService.fillExamplePost(exampleTO), HttpStatus.OK);
        } catch (RestClientException restClientException) {
            LOG.error("Error project-example getProjectExamplePost: {}", restClientException);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
