package com.gem.demo.control;

import com.gem.demo.entity.Message;
import com.gem.demo.entity.MessageCatory;
import com.gem.demo.entity.User;
import com.gem.demo.service.MessageService;
import com.gem.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController//这是jsp格式使用,但是@RestController是json格式使用
public class Usercontrol {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;


    @RequestMapping("/userinfors")
    public List<User> userList(){
        //无jsp，在浏览器上我们是使用json格式
        return userService.userList();
    }

    @RequestMapping("/talk")
    public void talk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得类型，并以域对象的形式发送到jsp 中
        List<MessageCatory> catories=messageService.getAllMessageCatory();
        request.setAttribute("messageCatory",catories);
        request.getRequestDispatcher("/talk.jsp").forward(request,response);
    }

    @RequestMapping("/selectMessages")//这里id是前台用户传过来，这必须要一样
    public List<Message> selectMessage(int id,HttpServletRequest request,HttpServletResponse response){
        List<Message> messages=messageService.getMessageByCatory(id);
        return messages;
    }
}


















