package VoThuanLoi.DonutStoreSpring.repository;

import VoThuanLoi.DonutStoreSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}