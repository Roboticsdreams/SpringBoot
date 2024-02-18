package com.thinkconstructivespringbootswaggerui.controller;

import com.thinkconstructivespringbootswaggerui.model.User;
import com.thinkconstructivespringbootswaggerui.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "User", description = "User Api")
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(
            summary = "Save the given user",
            description = "save the give user data to data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/users")
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @Operation(
            summary = "Fetch all users",
            description = "fetches all user entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @Operation(
            summary = "Get the user based on user id",
            description = "retrieve the given user id user data from data source when its match the user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/users/{id}")
    public Optional<User> getUserByID(Long id) {
        return userService.getUserByID(id);
    }

    @Operation(
            summary = "Update the given user based on user id",
            description = "update the given user data from data source when its match the user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/users/{id}")
    public User updateUser(User user){
        return userService.updateUser(user);
    }

    @Operation(
            summary = "Delete the Given user",
            description = "delete the given user data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("/users")
    public void deleteUser(User user){
        userService.deleteUser(user);
    }
}
