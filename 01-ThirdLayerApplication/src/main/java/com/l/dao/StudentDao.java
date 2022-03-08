package com.l.dao;

import com.l.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getList();

    List<Student> getList(int pageNo, int pageSize);

    int gettotalCount();
}
