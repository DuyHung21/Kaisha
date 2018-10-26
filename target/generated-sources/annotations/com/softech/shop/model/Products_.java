package com.softech.shop.model;

import com.softech.shop.model.Categories;
import com.softech.shop.model.Images;
import com.softech.shop.model.OrderDetails;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T09:42:18")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, BigInteger> quantity;
    public static volatile SingularAttribute<Products, Integer> productId;
    public static volatile CollectionAttribute<Products, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Products, String> description;
    public static volatile SingularAttribute<Products, Integer> discount;
    public static volatile SingularAttribute<Products, Long> sellPrice;
    public static volatile SingularAttribute<Products, Integer> priority;
    public static volatile SingularAttribute<Products, Long> inputPrice;
    public static volatile CollectionAttribute<Products, Images> imagesCollection;
    public static volatile SingularAttribute<Products, String> productName;
    public static volatile SingularAttribute<Products, BigInteger> view;
    public static volatile SingularAttribute<Products, Categories> categoryId;
    public static volatile SingularAttribute<Products, Boolean> status;

}