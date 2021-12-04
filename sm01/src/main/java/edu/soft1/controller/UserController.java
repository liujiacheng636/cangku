package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login")//不被拦截的方法
    public String login(User user, HttpSession session,HttpServletRequest request){
        System.out.println("----login()-----");
        int flag =1;//调用业务层（业务层调用dao层），获取flag对象
        if(flag == 1){
            session.setAttribute("user",user);//登录对象
            return "welcome";//登录成功
        }
        request.setAttribute("error","密码或账号不正确");
        return "redirect:/index.jsp";//登录失败
    }


    @RequestMapping("/delete")//被拦截的方法
    public String delete(HttpServletRequest request){
    System.out.println("delete操作");
    request.setAttribute("CRUDmsg","删除完成！");
        return "hello";
    }


    @RequestMapping("/welcome")
    public String welcome(){
        System.out.println("welcome");

        return "welcome";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("logout");
        session.invalidate();
        return "redirect:/index.jsp";
    }


    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello()");
        return "hello";
    }


    @RequestMapping("/upload")
    public String upload(){
        System.out.println("upload()");
        return "";
    }




   /* @RequestMapping("reg")
    public String reg(User user){
        System.out.println("username="+user.getUsername());
        System.out.println("pwd="+user.getAge());
        System.out.println("birthday="+user.getBirthday());
        System.out.println("city="+user.getAddress().getCity());
        System.out.println("street="+user.getAddress().getStreet());
        System.out.println("phone="+user.getAddress().getPhone());
        return "hello";
    }*/
}
