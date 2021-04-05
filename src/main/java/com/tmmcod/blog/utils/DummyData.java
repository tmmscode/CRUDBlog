package com.tmmcod.blog.utils;

import com.tmmcod.blog.model.Post;
import com.tmmcod.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    BlogRepository bRepoDummy;

    //@PostConstruct
    public void savePosts (){
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Autor qualquer 1");
        post1.setData(LocalDate.now());
        post1.setTitulo("Titulo qualquer 1");
        post1.setTexto("Muita coisa escrita aqui, não sei mais o que fazer, ta dificil pensar em algo e vou colocar qualquer coisa");

        Post post2 = new Post();
        post2.setAutor("Autor qualquer 2");
        post2.setData(LocalDate.now());
        post2.setTitulo("Titulo qualquer 2");
        post2.setTexto("Muita coisa escrita aqui, não sei mais o que fazer, ta dificil pensar em algo e vou colocar qualquer coisa");

        Post post3 = new Post();
        post3.setAutor("Autor qualquer 3");
        post3.setData(LocalDate.now());
        post3.setTitulo("Titulo qualquer 3");
        post3.setTexto("Muita coisa escrita aqui, não sei mais o que fazer, ta dificil pensar em algo e vou colocar qualquer coisa");

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);

        for (Post post: postList){
            Post postSaved = bRepoDummy.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
