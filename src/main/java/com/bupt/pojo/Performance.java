package com.bupt.pojo;

/**
 * @author Radium
 * @date 2022/9/28 1:00 PM
 */

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

@SearchBean(
        tables = (" performance p" +
                " left join student s on s.id = p.student_id " +
                " left join class c on c.id = s.class_id " +
                " left join school sc on sc.id = c.school_id ")

)
@Data
public class Performance {
    @DbField("s.id")
    Integer id;
    @DbField("s.name")
    String name;
    @DbField("p.score")
    Integer score;
    @DbField("sc.id")
    Integer schoolId;
    @DbField("c.id")
    Integer classId;
}