package com.softech.shop.model;

import com.softech.shop.model.Customers;
import com.softech.shop.model.Employees;
import com.softech.shop.model.PaymentMethods;
import com.softech.shop.model.Shipping;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T09:42:18")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Long> total;
    public static volatile SingularAttribute<Orders, Shipping> shippingId;
    public static volatile SingularAttribute<Orders, Integer> orderId;
    public static volatile SingularAttribute<Orders, PaymentMethods> paymentMethodId;
    public static volatile SingularAttribute<Orders, Customers> customerId;
    public static volatile SingularAttribute<Orders, Integer> discount;
    public static volatile SingularAttribute<Orders, String> orderCode;
    public static volatile SingularAttribute<Orders, Integer> tax;
    public static volatile SingularAttribute<Orders, Employees> employeeId;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, String> status;

}