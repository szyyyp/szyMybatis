package com.bupt.service;

import com.bupt.mapper.DeptDao;
import com.bupt.pojo.Dept;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptDao, Dept> {

    public DeptServiceImpl() {
        super();
    }
}
