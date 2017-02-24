package entity;

import entity.OrderdetailPK;
import entity.Orders;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-23T10:35:55")
@StaticMetamodel(Orderdetail.class)
public class Orderdetail_ { 

    public static volatile SingularAttribute<Orderdetail, Product> product;
    public static volatile SingularAttribute<Orderdetail, OrderdetailPK> orderdetailPK;
    public static volatile SingularAttribute<Orderdetail, Integer> quantityOrdered;
    public static volatile SingularAttribute<Orderdetail, Orders> orders;
    public static volatile SingularAttribute<Orderdetail, Short> orderLineNumber;
    public static volatile SingularAttribute<Orderdetail, Double> priceEach;

}