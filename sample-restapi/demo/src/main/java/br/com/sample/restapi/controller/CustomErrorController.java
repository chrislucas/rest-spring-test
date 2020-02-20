package br.com.sample.restapi.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handlerError(HttpServletResponse response) {
		ModelAndView mView = new ModelAndView();
		
		switch (response.getStatus()) {
			case 404:
				mView.setViewName("error-404");
				break;
			case 403:
				mView.setViewName("error-403");
				break;
			case 500:
				mView.setViewName("error-500");
				break;
			default:
				mView.setViewName("error");
				break;
		}
		
		
		return mView;
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
