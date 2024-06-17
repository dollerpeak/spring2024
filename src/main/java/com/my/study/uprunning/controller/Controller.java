package com.my.study.uprunning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.study.uprunning.data.Coffee;

@RestController
@RequestMapping("/uprunning")
public class Controller {
	List<Coffee> coffeeList = new ArrayList<>();
	Coffee a = new Coffee();

	public Controller() {
		coffeeList.addAll(List.of(new Coffee("1", "mega"), new Coffee("2", "compose"), new Coffee("3", "bback"), new Coffee("4", "starbucks")));
	}

	@GetMapping("/home")
	public String home() {
		return "welcome";
	}	
	
	@GetMapping("/coffee")
	public List<Coffee> getCoffee() {
		return coffeeList;
	}
	
	@GetMapping("/coffee/{id}")
	public Coffee getCoffeeById(@PathVariable String id) {
		for (Coffee coffee : coffeeList) {
			if (coffee.getId().equals(id) == true) {
				return coffee;
			}
		}

		return null;
	}
	
//	get  	읽기, 특정상태코드 없음		
//	post 	생성, 특정상태코드 권장
//	put		없으면 생성(post, 201), 있으면 업데이트200, 특정상태코드 필수 ResponseEntity<>(coffee, HttpStatus.OK)
//	delete	삭제, 특정상태코드 권장
//	
//	각각의 파라메터 받는 방법과
//	map으로 값을 보낼때 불편하니 swagger 사용법을 다시 확인하자
	
	
}
