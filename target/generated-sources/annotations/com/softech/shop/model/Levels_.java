package com.softech.shop.model;

import com.softech.shop.model.Employees;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T11:18:46")
@StaticMetamodel(Levels.class)
public class Levels_ { 

    public static volatile CollectionAttribute<Levels, Employees> employeesCollection;
    public static volatile SingularAttribute<Levels, Integer> levelId;
    public static volatile SingularAttribute<Levels, String> levelName;

}