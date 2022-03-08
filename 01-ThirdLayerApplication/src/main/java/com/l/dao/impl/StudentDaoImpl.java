package com.l.dao.impl;

import com.l.dao.StudentDao;
import com.l.entity.Student;
import com.l.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner queryRunner=new QueryRunner();

    Connection connection=DruidUtil.getConnection();


    @Override
    public List<Student> getList() {
        return null;
    }

    @Override
    public List<Student> getList(int pageNo, int pageSize) {
        String sql="select *from student limit ?, ?";
        //从哪开始
        int start=(pageNo-1) * pageSize;
        //查多少条
        List<Student> list=null;
        try{
            list = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class),start,pageSize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    //获取总数量
    @Override
    public int gettotalCount() {
        String sql="select * from student";
        List<Student> list=null;

        try {
            list=queryRunner.query(connection,sql,new BeanListHandler<>(Student.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
