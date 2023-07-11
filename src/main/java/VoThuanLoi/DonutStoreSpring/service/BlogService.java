package VoThuanLoi.DonutStoreSpring.service;

import VoThuanLoi.DonutStoreSpring.entity.Blog;
import VoThuanLoi.DonutStoreSpring.entity.Product;
import VoThuanLoi.DonutStoreSpring.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAll(){return blogRepository.findAll();}
    public void saveBlog(Blog b){blogRepository.save(b);}
    public Blog getBlogById(Long id){
        return blogRepository.findById(id).orElse(null);
    }
    public void deleteBlog(Long id){
        blogRepository.deleteById(id);
    }
}
