package com.bupt.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    Integer id;
    String username;
    String password;

    Date birthday;

}
