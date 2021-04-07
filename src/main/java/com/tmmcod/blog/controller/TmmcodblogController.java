package com.tmmcod.blog.controller;

import com.tmmcod.blog.model.Post;
import com.tmmcod.blog.service.TmmcodblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class TmmcodblogController {

    @Autowired
    TmmcodblogService tmmcodblogService;

    @GetMapping ("/posts")
    public ModelAndView getPosts () {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = tmmcodblogService.findAll ();
        mv.addObject("posts", posts);
        return mv;

    }

    @GetMapping ("/posts/{id}")
    public ModelAndView getPostDetails (@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = tmmcodblogService.findById(id);
        mv.addObject("post", post);
        return mv;

    }



}
