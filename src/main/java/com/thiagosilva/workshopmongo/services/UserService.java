package com.thiagosilva.workshopmongo.services;

import com.thiagosilva.workshopmongo.domain.User;
import com.thiagosilva.workshopmongo.dto.UserDTO;
import com.thiagosilva.workshopmongo.repository.UserRepository;
import com.thiagosilva.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
