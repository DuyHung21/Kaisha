package com.softech.shop.model;

import com.softech.shop.model.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T09:42:18")
@StaticMetamodel(Shipping.class)
public class Shipping_ { 

    public static volatile SingularAttribute<Shipping, String> address;
    public static volatile SingularAttribute<Shipping, Integer> shippingId;
    public static volatile SingularAttribute<Shipping, String> shippingName;
    public static volatile SingularAttribute<Shipping, String> phone;
    public static volatile CollectionAttribute<Shipping, Orders> ordersCollection;
    public static volatile SingularAttribute<Shipping, String> email;

}