package VoThuanLoi.DonutStoreSpring.controller;

import VoThuanLoi.DonutStoreSpring.entity.Product;
import VoThuanLoi.DonutStoreSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAll();
    }
}
