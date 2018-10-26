package com.softech.shop.model;

import com.softech.shop.model.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T09:42:18")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile CollectionAttribute<Categories, Products> productsCollection;
    public static volatile SingularAttribute<Categories, String> imageUrl;
    public static volatile SingularAttribute<Categories, String> categoryName;
    public static volatile SingularAttribute<Categories, Integer> categoryId;
    public static volatile SingularAttribute<Categories, Boolean> status;

}