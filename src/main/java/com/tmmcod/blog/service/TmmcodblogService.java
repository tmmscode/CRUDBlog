package com.tmmcod.blog.service;

import com.tmmcod.blog.model.Post;

import java.util.List;

public interface TmmcodblogService {

    List<Post> findAll ();
    Post findById (long id);
    Post save (Post post);
    void delete (long id);

}
