package com.company.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.company.biz.user.User;
import com.company.biz.user.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
   
   @Autowired
   private UserService userService;
   
   @GetMapping("/login.do")
   public ModelAndView login(ModelAndView mav) {
      System.out.println("login.do 실행 Get");
      mav.setViewName("login");
      return mav;
   }
   
   @PostMapping("/login.do")
   public ModelAndView getUser(User user,HttpSession session,ModelAndView mav) {
      System.out.println("login.do 실행 Post");
      if(userService.getUser(user)!=null) {
         System.out.println("로그인 처리");
         session.setAttribute("name",userService.getUser(user).getName());
         mav.setViewName("redirect:getBoardList.do?page=1");
         
      }else {
         mav.setViewName("redirect:login.do");
      }
      
      return mav;
   }
   
   
}