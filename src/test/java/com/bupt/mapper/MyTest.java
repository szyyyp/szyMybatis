package com.bupt.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.pojoTest.Dept;
import com.bupt.pojoTest.BanJi;
import com.bupt.pojoTest.Student;
import com.bupt.mapperTest.BanJiDao;
import com.bupt.mapperTest.DeptDao;
import com.bupt.mapperTest.StudentDao;
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
    private BanJiDao banJiDao;

    @Autowired
    private StudentDao studentDao;

    @Test
    void test01(){
        List<Dept> depts = deptDao.selectList(null);

        List<Dept> deptList = new ArrayList<>();

        for (Dept dept : depts) {
            //1、根据部门ID查看班级信息
            List<BanJi> classList = banJiDao.selectList(new QueryWrapper<BanJi>().eq("did", dept.getDid()));
            dept.setClassList(classList);
            //2、根据班级ID查看学生信息
            for (BanJi aClass : classList) {
                List<Student> studentList = studentDao.selectList(new QueryWrapper<Student>().eq("cid", aClass.getCid()));
                aClass.setStudentList(studentList);
            }
            deptList.add(dept);
        }

        System.out.println(JSON.toJSONString(deptList));

    }


}
