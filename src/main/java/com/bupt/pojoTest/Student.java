package com.bupt.pojoTest;

import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

import java.util.Date;
@SearchBean(
        tables = "student s",
        autoMapTo = "s"
)
@Data
public class Student {

    private Integer id;

    private String name;

    private Integer classId;

    private Date birthday;

}