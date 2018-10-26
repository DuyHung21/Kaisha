/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.shop.controllers;

import com.softech.shop.model.Products;
import com.softech.shop.services.CategoryService;
import com.softech.shop.services.ImageService;
import com.softech.shop.services.ProductService;
import com.softech.shop.view_model.ProductToView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/users")
public class ProductControllerClient {

    private static int currentPage = 1;
    private static int pageSize = 12;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    //get product and add field imageUrl
    public ProductToView getProduct(int productId) {
        ProductToView productView = new ProductToView();
        Products product = productService.findById(productId).get();
        productView.setProductId(productId);
        productView.setProductName(product.getProductName());
        productView.setCategoryId(product.getCategoryId().getCategoryId());
        productView.setCategoryName(product.getCategoryId().getCategoryName());
        productView.setInputPrice(product.getInputPrice());
        productView.setSellPrice(product.getSellPrice());
        productView.setDescription(product.getDescription());
        productView.setQuantity(product.getQuantity());
        productView.setDiscount(product.getDiscount());
        productView.setImageUrl(imageService.findByProduct(product.getProductId()).getUrl());
        return productView;
    }

    //get all relation product except current product
    public List<ProductToView> getRelationProduct(int categoryId, int productId) {
        List<ProductToView> listRelation = new ArrayList<>();
        List<Products> listFromDb = productService.findByTop(categoryId);
        for (int i = 0; i < listFromDb.size(); i++) {
            if (listFromDb.get(i).getProductId() == productId) {
                continue;
            }
            ProductToView productView = new ProductToView();
            productView.setProductId(listFromDb.get(i).getProductId());
            productView.setProductName(listFromDb.get(i).getProductName());
            productView.setCategoryId(listFromDb.get(i).getCategoryId().getCategoryId());
            productView.setSellPrice(listFromDb.get(i).getSellPrice());
            productView.setImageUrl(imageService.findByProduct(listFromDb.get(i).getProductId()).getUrl().trim());
            listRelation.add(productView);
        }
        return listRelation;
    }  
}
