package VoThuanLoi.DonutStoreSpring.controller;

import VoThuanLoi.DonutStoreSpring.entity.Product;
import VoThuanLoi.DonutStoreSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAll();
    }
    
}
