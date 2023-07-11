package VoThuanLoi.DonutStoreSpring.controller;

import VoThuanLoi.DonutStoreSpring.entity.Blog;
import VoThuanLoi.DonutStoreSpring.entity.Product;
import VoThuanLoi.DonutStoreSpring.service.BlogService;
import VoThuanLoi.DonutStoreSpring.service.FileUpload;
import VoThuanLoi.DonutStoreSpring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BlogService blogService;
    private final FileUpload fileUpload;

    @GetMapping("/dashboard")
    public String index(Model model){
        model.addAttribute("listProduct",productService.getAll());
        model.addAttribute("listBlog",blogService.getAll());

        return "admin/index";
    }

    //Handel product
    @GetMapping("/product/create")
    public String createProduct(@NotNull Model model){
        model.addAttribute("product",new Product());
        return "admin/product/create";
    }
    @PostMapping("/product/create")
    public String createProduct(Product newProduct,
                                @RequestParam MultipartFile imageProduct,
                                 Model model) throws IOException {
        if (imageProduct != null && imageProduct.getSize() > 0){
            String imageURL = fileUpload.uploadFile(imageProduct);
            newProduct.setImage(imageURL);
        }
        productService.saveProduct(newProduct);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){
        Product product = productService.getProductById(id);
        if (product == null){
            return "not-found";
        }
        model.addAttribute("product", product);
        return "admin/product/edit";
    }
    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") Long id,
                              @ModelAttribute("product") Product updateProduct,
                              @RequestParam MultipartFile imageProduct,
                              Model model) throws IOException {
        Product product = productService.getProductById(id);
        if (product == null){
            return "error";
        }

        if (imageProduct != null && imageProduct.getSize() > 0){
            String imageURL = fileUpload.uploadFile(imageProduct);
            product.setImage(imageURL);
        }

        product.setId(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setType(updateProduct.getType());
        product.setDescription(updateProduct.getDescription());
        product.setIngredients(updateProduct.getIngredients());
        product.setPrice(updateProduct.getPrice());
        product.setTrending(updateProduct.getTrending());

        productService.saveProduct(product);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/admin/dashboard";
    }


    //Handel blog
    @GetMapping("/blog/create")
    public String createBlog(@NotNull Model model){
        model.addAttribute("blog",new Blog());
        return "admin/blog/create";
    }
    @PostMapping("/blog/create")
    public String createBlog(Blog newBlog,
                             @RequestParam MultipartFile imageBlog,
                                Model model) throws IOException {
        if (imageBlog != null && imageBlog.getSize() > 0){
            String imageURL = fileUpload.uploadFile(imageBlog);
            newBlog.setImage(imageURL);
        }
        blogService.saveBlog(newBlog);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/blog/edit/{id}")
    public String editBlog(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.getBlogById(id);
        if (blog == null){
            return "not-found";
        }
        model.addAttribute("blog", blog);
        return "admin/blog/edit";
    }
    @PostMapping("/blog/edit/{id}")
    public String editBlog(@PathVariable("id") Long id,
                           @ModelAttribute("blog") Blog updateBlog,
                           @RequestParam MultipartFile imageBlog,
                           Model model) throws IOException {
        Blog blog = blogService.getBlogById(id);
        if (blog == null){
            return "error";
        }

        if (imageBlog != null && imageBlog.getSize() > 0){
            String imageURL = fileUpload.uploadFile(imageBlog);
            blog.setImage(imageURL);
        }

        blog.setId(updateBlog.getId());
        blog.setName(updateBlog.getName());
        blog.setAuthor(updateBlog.getAuthor());
        blog.setP1(updateBlog.getP1());
        blog.setP2(updateBlog.getP2());
        blog.setP3(updateBlog.getP3());
        blog.setP4(updateBlog.getP4());
        blog.setMain(updateBlog.getMain());
        blog.setIsNew(updateBlog.getIsNew());

        blogService.saveBlog(blog);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/dashboard";
    }
}
