package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {
	
	@GetMapping("/html")
	public String html() {
		System.out.println("html 파일이 요청됨");
		return "redirect:hello.html";
	}
	
	@GetMapping("/image")
	public String image() {
		System.out.println("이미지 파일이 요청됨");
		return "redirect:image/dog.jpg";
	}
	
	@GetMapping("/jsp")
	public String jsp(Model model) {
		System.out.println("jsp 파일이 요청됨");
		model.addAttribute("username", "홍길동");
		return "hello";
	}
	
	
	
}
