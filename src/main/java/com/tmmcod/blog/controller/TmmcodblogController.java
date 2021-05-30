package com.tmmcod.blog.controller;

import com.tmmcod.blog.model.Post;
import com.tmmcod.blog.repository.BlogRepository;
import com.tmmcod.blog.service.TmmcodblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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

    @GetMapping ("/newpost")
    public  String getPostForm(){
        return "postForm";
    }


    @GetMapping ("/postEdit/{id}")
    public String getEditForm(@PathVariable("id") long id, Model model) {
        Post post = tmmcodblogService.findById(id);
        model.addAttribute("post", post);
        return "postEdit";
    }

    @PostMapping ("/newpost")
    public String savePost (Post post, BindingResult result, RedirectAttributes attributes){
        if (post.getTitulo().isEmpty() || post.getAutor().isEmpty() || post.getTexto().isEmpty()){
            // Validar campos vazios
            attributes.addFlashAttribute("mensagem", "Existem campos que não foram preenchidos");
            return "redirect:/blog/newpost";
        }

        if (post.getTitulo().length() < 5 || post.getAutor().length() < 1 || post.getTexto().length() < 20){
            // Validar tamanho dos campos
            attributes.addFlashAttribute("mensagem", "Existem campos com dados inconsistentes");
            return "redirect:/blog/newpost";
        }


        post.setData(LocalDate.now());
        tmmcodblogService.save(post);
        return "redirect:/blog/posts";
    }

    @PostMapping("/saveEdit/{id}")
    public String updatePost (@PathVariable("id") long id, Post post,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            return "postEdit";
        }

        tmmcodblogService.save(post);
        return "redirect:/blog/posts";
    }

    /* TODO: Criar endpoint para delete dos posts
    *   (em andamento)*/



/*    @PutMapping ("/posts/{id}")
    public ModelAndView getPostDetails (@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = tmmcodblogService.findById(id);
        mv.addObject("post", post);
        return mv;

    }*/


}
