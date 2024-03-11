package com.bupt.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.pojo.Dept;
import com.bupt.pojo.Class;
import com.bupt.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyTest {

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentDao studentDao;

    @Test
    void test01(){
        List<Dept> depts = deptDao.selectList(null);

        List<Dept> deptList = new ArrayList<>();

        for (Dept dept : depts) {
            //1、根据部门ID查看班级信息
            List<Class> classList = classDao.selectList(new QueryWrapper<Class>().eq("did", dept.getDid()));
            dept.setClassList(classList);
            //2、根据班级ID查看学生信息
            for (Class aClass : classList) {
                List<Student> studentList = studentDao.selectList(new QueryWrapper<Student>().eq("cid", aClass.getCid()));
                aClass.setStudentList(studentList);
            }
            deptList.add(dept);
        }

        System.out.println(JSON.toJSONString(deptList));

    }

}
