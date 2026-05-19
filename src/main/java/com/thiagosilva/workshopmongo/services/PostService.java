package com.thiagosilva.workshopmongo.services;

import com.thiagosilva.workshopmongo.domain.Post;
import com.thiagosilva.workshopmongo.domain.User;
import com.thiagosilva.workshopmongo.repository.PostRepository;
import com.thiagosilva.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

}
