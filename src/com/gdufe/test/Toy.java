package com.gdufe.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/4/3 18:31
 */
public class Toy {
    private double price;
    private String color;
    Toy(String color, double price){
        this.color = color;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Toy{");
        sb.append("price=").append(price);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("red", 10));
        toys.add(new Toy("Yellow", 10));
        toys.add(new Toy("red", 10));
        System.out.println(toys);
        long red = toys.stream().filter(e -> {
            System.out.println(e.getColor().equals("red"));
            return e.getColor().equals("red");
        }).count();

//        double totalPrice = toys.stream().filter(e -> e.color.equals("red"))
//                .mapToDouble(e->e.getPrice())
//                .sum();
        System.out.println(red);


    }
}
