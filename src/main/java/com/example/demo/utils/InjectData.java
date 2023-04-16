package com.example.demo.utils;

import com.example.demo.model.Post;
import com.example.demo.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class InjectData {

    @Autowired
    CodeblogRepository codeblogRepository;
    //@PostConstruct
    public void savePost(){

        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
       //post1.setId(1L);
        post1.setAutor("Edinaelson Santos");
        post1.setData(LocalDate.now());
        post1.setTitulo("Linux");
        post1.setTexto("Linux e um termo popularmente empregado para se referir a sistemas operativos ou sistemas operacionais que utilizam o nucleo Linux");

        Post post2 = new Post();
        //post2.setId(2L);
        post2.setAutor("Lucas Modric");
        post2.setData(LocalDate.now());
        post2.setTitulo("Windows");
        post2.setTexto("Windows e u sistema operacional fundado por bill gates um rapaz inteligente e atencioso e revolucionario, mudou para sempre o mercado atual.");

        postList.add(post1);
        postList.add(post2);

        for (Post post: postList){
            Post postSave = codeblogRepository.save(post);
            System.out.println("Id: " + postSave.getId());
            System.out.println("Author: " + postSave.getAutor());
        }

    }

}
