package com.bupt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qingshi
 * @date 2023/1/5 8:53
 * info:
 */
@Data
@TableName("t_student")
@SearchBean(tables = "t_student")
public class TStudent implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private int sex;

    private String grade;

    int age;

}

