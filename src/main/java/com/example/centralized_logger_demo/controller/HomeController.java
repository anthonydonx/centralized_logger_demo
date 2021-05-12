/**
 * @author anthonydonx
 */
package com.example.centralized_logger_demo.controller;

import com.example.centralized_logger_demo.aop.EnableTracking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("endpoint")
    @EnableTracking
    public ResponseEntity<String> endpoint(){
        return ResponseEntity.ok("Hello endpoint");
    }
}
