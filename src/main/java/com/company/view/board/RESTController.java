package com.company.view.board;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.biz.user.User;

// REST 컨트롤러를 만들기 위해서는 컨트롤러 클래스에 @controller어노테이션이 아닌 @restController를 사용함
// 컨트롤러는 메소드가 반환한 데이터를 자동으로 json타입으로 변환
@RestController
public class RESTController {
	
	// get : select
	@GetMapping("/board")
	public User httpGet() {
		User findUser=User.builder()
				.id("1")
				.name("홍길동")
				.password("1234")
				.role("hong@hong.com")
			.build();
			
			return findUser;
	}

	// post : insert
	@PostMapping("/board")
	public String httpPost(@RequestBody User user) {
		return "Post 요청 처리 입력값"+user.toString();
	}
	
	// put : update 
	@PutMapping("/board")
	public String httpPut() {
		return "Put 요청 처리";
	}
	
	// delete : delete
	@DeleteMapping("/board")
	public String httpDelete() {
		return "delete 요청 처리";
	}
}
