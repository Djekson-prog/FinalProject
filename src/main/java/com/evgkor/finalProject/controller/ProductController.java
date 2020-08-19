package com.evgkor.finalProject.controller;

import com.evgkor.finalProject.bean.Product;
import com.evgkor.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homePageView(){
        String keyword=null;
//
        return "index";
//        return listByPage(model,1,keyword);
    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model,
                             @PathVariable("pageNumber") int currentPage,
                             @Param("keyword") String keyword) {
        Page<Product> page = productService.findAllProduct(keyword,currentPage);
        long totalItems=page.getTotalElements();
        int totalPages=page.getTotalPages();
        List<Product> listProducts=page.getContent();
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword",keyword);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        return "product-list";
    }

    @GetMapping("/new")
    public String createProductForm(Model model) {
        Product product1=new Product();
        model.addAttribute("product1",product1);
        return "product-create";
    }

    @PostMapping("/save")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/index";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "redirect:/index";
    }
    @GetMapping("/edit/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-update";
    }
    @PostMapping("/product-update")
    public String updateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/index";
    }

}


