package com.blog.BloggingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model; // ✅ Corrected import

import com.blog.BloggingProject.model.Post;
import com.blog.BloggingProject.repository.PostRepo;

@Controller
public class PostController {
    
    @Autowired
    PostRepo repo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPosts", repo.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "new_Post";
    }
  
    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id, Model model){
        model.addAttribute("post", repo.findById(id)); 
        return "edit_Post";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";
}
    
@GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id, Model model){
   repo.deleteById(id);
   return "redirect:/";
}

}