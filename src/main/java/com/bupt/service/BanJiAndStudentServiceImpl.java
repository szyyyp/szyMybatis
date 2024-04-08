package com.bupt.service;

import com.bupt.mapper.BanJiDao;
import com.bupt.mapper.StudentDao;
import com.bupt.pojo.BanJi;
import com.bupt.pojo.Student;
import org.springframework.stereotype.Service;


@Service
public class BanJiAndStudentServiceImpl extends
        HeadAndDetail<BanJiDao, BanJi, StudentDao, Student>
{


    @Override
    public boolean addHead(BanJi h) {
        return false;
    }
}
