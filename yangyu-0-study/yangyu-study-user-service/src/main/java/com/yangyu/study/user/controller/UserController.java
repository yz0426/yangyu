package com.yangyu.study.user.controller;

import com.yangyu.study.user.model.User;
import com.yangyu.study.user.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;

/**
 * Created by youz on 2017/10/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserReponsitory userReponsitory;

    @GetMapping("/{id}")
    public User info(@PathVariable Long id){
        return userReponsitory.findOne(id);
    }

    @GetMapping("hello")
    public String hello(){
        return "hello world";
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
    }
}
