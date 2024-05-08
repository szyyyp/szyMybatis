package com.bupt.pojoTest;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Dept {

    private Integer did;

    private String dname;

    @TableField(exist = false)
    private List<BanJi> classList;

}