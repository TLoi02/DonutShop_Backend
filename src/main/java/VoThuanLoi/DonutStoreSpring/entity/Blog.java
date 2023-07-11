package VoThuanLoi.DonutStoreSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String image;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String main;
    private int isNew;
}
