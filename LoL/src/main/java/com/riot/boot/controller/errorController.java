package com.riot.boot.controller;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class errorController implements ErrorController {
	private static final String ERROR_PATH= "/error";

	
	public  String getErrorPath() {
		return ERROR_PATH;
	}
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request,Model model) {
		
		int status=(Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		log.info(RequestDispatcher.ERROR_STATUS_CODE);
		
		
		if(status==500) {
			model.addAttribute("msg","소환사님을 찾을 수 없습니다.");
			return "error";
		}else if(status==404) {
			model.addAttribute("msg","잘못된 입력입니다.");
			return "error";
		}
		model.addAttribute("msg",status);
		return "error";
	}
}
