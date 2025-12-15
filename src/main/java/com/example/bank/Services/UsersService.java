package com.example.bank.Services;

import com.example.bank.Entities.Users;
import com.example.bank.Repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository userRepository;

    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public Users saveUser(Users user){
        return userRepository.save(user);
    }

    public Users updateUser(Users user){
        Users existing = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getFull_name() != null) existing.setFull_name(user.getFull_name());
        if (user.getEmail() != null) existing.setEmail(user.getEmail());
        if (user.getPassword_hash() != null) existing.setPassword_hash(user.getPassword_hash());
        if (user.getNational_id() != null) existing.setNational_id(user.getNational_id());
        if (user.getIs_active() != null) existing.setIs_active(user.getIs_active());
        if (user.getCreated_at() != null) existing.setCreated_at(user.getCreated_at());

        return userRepository.save(existing);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
