package com.sn.entity;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Integer id;
    private String name;
    private String pic;
    private Double price;
    private Integer num;

    public CartItem() {
        super();
    }

    public CartItem(Integer id, String name, String pic, Double price,
                    Integer num) {
        super();
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.price = price;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CartItem [id=" + id + ", name=" + name + ", pic=" + pic
                + ", price=" + price + ", num=" + num + "]";
    }

}
