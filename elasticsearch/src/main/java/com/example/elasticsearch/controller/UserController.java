package com.example.elasticsearch.controller;


import com.example.elasticsearch.document.User;
import com.example.elasticsearch.dto.UserDto;
import com.example.elasticsearch.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserDto userDto) {
        System.out.println(userDto.getName()+"NameHere");
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }


    @GetMapping("/searchuser/{query}")
    public JSONObject searchUser(@PathVariable("query") String query) {
        try {
            List<User> user = userService.searchUser(query);

            JSONObject data = new JSONObject();
            data.put("users", user);
            return  prepareReturnObject(200, "Search data", data);
        } catch (Exception e) {
            return prepareReturnObject(500, "Some error occurred", null);
        }
    }

    public JSONObject prepareReturnObject(int status, String message, JSONObject data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
        return jsonObject;
    }

}
