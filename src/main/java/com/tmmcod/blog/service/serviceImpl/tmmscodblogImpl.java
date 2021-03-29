package com.tmmcod.blog.service.serviceImpl;

import com.tmmcod.blog.model.Post;
import com.tmmcod.blog.repository.BlogRepository;
import com.tmmcod.blog.service.tmmcodblog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tmmscodblogImpl implements tmmcodblog {

    @Autowired
    BlogRepository blogRepo;

    @Override
    public List<Post> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Post findById(long id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return blogRepo.save(post);
    }
}
