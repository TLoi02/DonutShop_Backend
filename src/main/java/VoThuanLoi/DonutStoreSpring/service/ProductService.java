package VoThuanLoi.DonutStoreSpring.service;

import VoThuanLoi.DonutStoreSpring.entity.Product;
import VoThuanLoi.DonutStoreSpring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public void saveProduct(Product p){productRepository.save(p);}
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
