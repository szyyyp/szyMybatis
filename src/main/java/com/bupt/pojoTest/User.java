package com.bupt.pojoTest;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("user")
public class User {
    Integer id;
    String name;
    String password;

    Date birthday;

}
