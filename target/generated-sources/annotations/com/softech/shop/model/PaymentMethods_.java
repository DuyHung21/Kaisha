package com.softech.shop.model;

import com.softech.shop.model.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-25T09:42:49")
@StaticMetamodel(PaymentMethods.class)
public class PaymentMethods_ { 

    public static volatile SingularAttribute<PaymentMethods, Integer> paymentMethodId;
    public static volatile SingularAttribute<PaymentMethods, String> methodName;
    public static volatile CollectionAttribute<PaymentMethods, Orders> ordersCollection;
    public static volatile SingularAttribute<PaymentMethods, Boolean> status;

}