package com.softech.shop.model;

import com.softech.shop.model.Levels;
import com.softech.shop.model.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T11:18:46")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> bankAccount;
    public static volatile SingularAttribute<Employees, Date> lastLogin;
    public static volatile SingularAttribute<Employees, String> password;
    public static volatile SingularAttribute<Employees, String> address;
    public static volatile SingularAttribute<Employees, String> phone;
    public static volatile SingularAttribute<Employees, String> loginName;
    public static volatile SingularAttribute<Employees, Levels> levelId;
    public static volatile SingularAttribute<Employees, String> fullName;
    public static volatile SingularAttribute<Employees, Integer> employeeId;
    public static volatile CollectionAttribute<Employees, Orders> ordersCollection;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile SingularAttribute<Employees, Boolean> status;

}