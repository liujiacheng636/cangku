package edu.soft1.interceptor;

import edu.soft1.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response, Object o) throws Exception {

        HttpSession session = request.getSession();

        Object obj = session.getAttribute("user");

        if(obj != null && obj instanceof User){

           System.out.println("拦截器放行");
           return true;//通过
        }

        System.out.println("登陆失败");
        //转发跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        //重定向跳转
        //response.sendRedirect("/index.jsp");
        return false;//被拦截
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
