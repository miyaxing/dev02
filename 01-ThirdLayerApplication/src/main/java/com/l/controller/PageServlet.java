package com.l.controller;

import com.l.vo.PageInfo;
import com.l.entity.Student;
import com.l.service.StudentService;
import com.l.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/page")
public class PageServlet extends HttpServlet {
  //表示层依赖了业务逻辑层
   StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的请求参数
        String parameter=req.getParameter("pageNo");

        int pageNo=1;

        if (parameter !=null){
            pageNo=Integer.parseInt(parameter);
        }
        //每页显示多少条
        int pageSize=5;

        //获取一个对象，这个对象中应该包含了一些前端需要参数
        //当前页pageNo
        //每页显示多少条pageSize
        //总数据量数totalCount
        //总页数pageCount
        //每一页显示的所有内容List
        //封装成一个对象：pageInfo

        //通过依赖的传递获取了pageInfo
        PageInfo<Student> pageInfo = studentService.getPageInfo(pageNo,pageSize);

        //设置域对象
        req.setAttribute("pageInfo",pageInfo );

        //发送到前端
        req.getRequestDispatcher("page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
