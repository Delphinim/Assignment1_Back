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

/**
 * 注册控制器
 * @author TZQ
 *
 */

@WebServlet("/register")
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        LoginInfoService loginInfoService = new LoginInfoServiceImpl();
        LoginInfo user = new LoginInfo();
        user.setAccount(account);
        user.setPassword(password);
        loginInfoService.register(user);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
