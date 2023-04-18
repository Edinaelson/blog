package com.example.demo.utils;

import com.example.demo.model.Post;
import com.example.demo.repository.CodeblogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class InjectData {

    @Autowired
    CodeblogRepository codeblogRepository;
    //@PostConstruct
    public void savePost() throws IOException {

        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
       //post1.setId(1L);
        post1.setImg("/img/java.jpg");
        post1.setAutor("Edinaelson Santos");
        post1.setData(LocalDate.now());
        post1.setTitulo("Java");
        post1.setTexto("Aqui e um teste para capturar uma imagem.");

        /*
        Post post2 = new Post();
        //post2.setId(2L);
        post2.setAutor("Lucas Modric");
        post2.setData(LocalDate.now());
        post2.setTitulo("PHP");
        post2.setTexto("PHP e uma linguagem interpretada livre, usada originalmente apenas para o desenvolvimento de aplicacoes presentes e atuantes no lado do servidor, capazes de gerar conteudo dinamico na World Wide Web.");


         */
        postList.add(post1);
       //postList.add(post2);

        for (Post post: postList){
            Post postSave = codeblogRepository.save(post);
            System.out.println("Id: " + postSave.getId());
            System.out.println("Author: " + postSave.getAutor());
        }

    }

}
