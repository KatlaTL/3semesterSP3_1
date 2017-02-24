package entity;

import entity.Orderdetail;
import entity.Productline;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-23T10:35:55")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Short> quantityInStock;
    public static volatile SingularAttribute<Product, Double> buyPrice;
    public static volatile SingularAttribute<Product, Productline> productline;
    public static volatile SingularAttribute<Product, String> productCode;
    public static volatile SingularAttribute<Product, String> productScale;
    public static volatile SingularAttribute<Product, Double> msrp;
    public static volatile CollectionAttribute<Product, Orderdetail> orderdetailCollection;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, String> productVendor;
    public static volatile SingularAttribute<Product, String> productDescription;

}