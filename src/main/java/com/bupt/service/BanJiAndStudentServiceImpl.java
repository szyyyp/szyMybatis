package com.bupt.service;

import com.bupt.mapper.BanJiDao;
import com.bupt.mapper.StudentDao;
import com.bupt.pojo.BanJi;
import com.bupt.pojo.Student;
import org.springframework.stereotype.Service;


@Service
public class BanJiAndStudentServiceImpl extends
        BillServiceImpl<BanJiDao, BanJi, StudentDao, Student>
{


    @Override
    public boolean addHead(BanJi h,Student t) {
        return false;
    }
}
