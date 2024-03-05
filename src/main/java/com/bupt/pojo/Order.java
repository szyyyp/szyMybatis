package com.bupt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    Long id;
    Date orderTime;
    User user;
}
