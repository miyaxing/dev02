package com.l.service;

import com.l.vo.PageInfo;
import com.l.entity.Student;

//业务层我接口
public interface StudentService {
    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}
