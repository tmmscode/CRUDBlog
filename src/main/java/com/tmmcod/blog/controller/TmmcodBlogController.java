package com.tmmcod.blog.controller;

import com.tmmcod.blog.model.Post;
import com.tmmcod.blog.service.TmmcodblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class TmmcodBlogController {

    @Autowired
    TmmcodblogService tmmcodblogService;

/*    @RequestMapping (value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts () {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = tmmcodblogService.findAll ();
        mv.addObject("posts", posts);
        return mv;

    }*/

    @GetMapping ("/posts")
    public ModelAndView getPosts () {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = tmmcodblogService.findAll ();
        mv.addObject("posts", posts);
        return mv;

    }



}
