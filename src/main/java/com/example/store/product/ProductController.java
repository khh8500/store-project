package com.example.store.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public String list(HttpServletRequest request){
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);

        return "/product/list";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        Product product = productService.findById(id);
        request.setAttribute("product", product);

        return "product/detail";
    }

    @PostMapping("/product/save")
    public String save(ProductRequest.SaveDTO reqDTO) {
        productService.save(reqDTO);
        return "redirect:/";
    }

    @GetMapping("/product/save-form")
    public String saveForm() {
        return "/product/save-form";
    }

    @PostMapping("/product/{id}/update")
    public String update(@PathVariable Integer id){
        return "redirect:/product/";
    }

    @GetMapping("/product/update-form")
    public String updateForm(){
        return "/product/update-form";
    }

    @PostMapping("product/{id}/delete")
    public String delete(@PathVariable Integer id){
        return "redirect:/";
    }

    @GetMapping("/")
    public String main() {
        return "/index";
    }

}