package com.bupt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;
@Data
public class Class {

    private Integer cid;

    private String cname;

    @TableField(exist = false)
    private List<Student> studentList;
}
