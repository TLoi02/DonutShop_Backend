package VoThuanLoi.DonutStoreSpring.controller;

import VoThuanLoi.DonutStoreSpring.entity.Blog;
import VoThuanLoi.DonutStoreSpring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> handelGetBlog(){
        return blogService.getAll();
    }
}
