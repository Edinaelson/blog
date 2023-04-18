package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPost(){
        ModelAndView mv  = new ModelAndView("posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);

        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") Long id){
        ModelAndView mv  = new ModelAndView("postDetails");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);

        return mv;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndex(){
        ModelAndView mv  = new ModelAndView("index");
        List<Post> index = codeblogService.findAll();
        mv.addObject("index", index);

        return mv;
    }

}
