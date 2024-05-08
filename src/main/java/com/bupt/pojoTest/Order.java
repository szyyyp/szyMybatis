package com.bupt.pojoTest;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    Long id;
    Date orderTime;
    User user;
}
