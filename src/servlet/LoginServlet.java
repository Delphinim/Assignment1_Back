package servlet;

import entity.LoginInfo;
import service.LoginInfoService;
import service.impl.LoginInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录控制器
 * @author TZQ
 *
 */
@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.getRequestDispatcher("/login.jsp").forward(req,resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String account= req.getParameter("account");
        String password= req.getParameter("password");
        LoginInfoService loginInfoService=new LoginInfoServiceImpl();
        LoginInfo user=loginInfoService.login(account, password);

        if(user.getAccount()!=null) {
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }
        else {
            //这句话的意思，是让浏览器用utf8来解析返回的数据
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            //这句话的意思，是告诉servlet用UTF-8转码
            resp.setCharacterEncoding("UTF-8");
            //实现弹窗功能
            PrintWriter out=resp.getWriter();
            out.print("<script>alert('用户名或密码错误，请重新输入!'); window.location='login.jsp';</script>");
            out.flush();
            out.close();
        }

    }


}
