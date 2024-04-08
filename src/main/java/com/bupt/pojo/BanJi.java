package com.bupt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;
@Data
@TableName("class")
public class BanJi {

    private Integer cid;

    private String cname;

    @TableField(exist = false)
    private List<Student> studentList;
}
