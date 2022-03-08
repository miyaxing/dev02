package com.l.service.impl;

import com.l.dao.StudentDao;
import com.l.dao.impl.StudentDaoImpl;
import com.l.vo.PageInfo;
import com.l.entity.Student;
import com.l.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //业务逻辑层依赖数据访问层
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
       int totalCount=studentDao.gettotalCount();
        List<Student> list=studentDao.getList(pageNo,pageSize);
//        PageInfo<Student> pageInfo=new PageInfo<>(totalCount,pageSize,pageNo,list);
        return new PageInfo<>(totalCount,pageNo,pageSize,list);
    }
}
