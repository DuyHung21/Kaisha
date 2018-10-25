package com.softech.shop.model;

import com.softech.shop.model.Orders;
import com.softech.shop.model.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-25T09:42:49")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Integer> quantity;
    public static volatile SingularAttribute<OrderDetails, Products> productId;
    public static volatile SingularAttribute<OrderDetails, Orders> orderId;
    public static volatile SingularAttribute<OrderDetails, Long> price;
    public static volatile SingularAttribute<OrderDetails, Integer> discount;
    public static volatile SingularAttribute<OrderDetails, Integer> tax;
    public static volatile SingularAttribute<OrderDetails, Integer> orderDetailId;

}