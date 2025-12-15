package com.example.bank.Controllers;

import com.example.bank.Entities.Users;
import com.example.bank.Services.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public Users saveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }

    @PutMapping("/update/{id}")
    public Users updateUser(@PathVariable Integer id, @RequestBody Users user){
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
