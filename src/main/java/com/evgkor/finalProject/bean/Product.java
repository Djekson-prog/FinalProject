package com.evgkor.finalProject.bean;

import lombok.Data;

import java.math.BigDecimal;
import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "actual_price")
    private BigDecimal actualPrice;
}
