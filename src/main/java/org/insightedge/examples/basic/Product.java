package org.insightedge.examples.basic;



import java.io.Serializable;

public class Product implements Serializable{

    //org.insightedge.examples.basic.Product(i, "Description of product " + i, Random.nextInt(10), Random.nextBoolean())


    long id;


    String description;


    int quantity;


    boolean featuredProduct;

    public Product(long id, String desc, int quantity , boolean isFeatureProduct){

        this.id = id;
        this.description=desc;
        this.quantity=quantity;
        this.featuredProduct=isFeatureProduct;
    }


}
