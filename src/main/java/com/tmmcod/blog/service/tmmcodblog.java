package com.tmmcod.blog.service;

import com.tmmcod.blog.model.Post;

import java.util.List;

public interface tmmcodblog {

    List<Post> findAll ();
    Post findById (long id);
    Post save (Post post);

}
