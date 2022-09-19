package com.rest.webservices.webservices1.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
	
	private MessageSource messageSource;
	
	public HelloworldController (MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@GetMapping(path="/hello-world-i18n")
	
	public String helloworldI18n() {
		Locale locale =LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null," Default Message", locale);
		
	}
	
	@GetMapping(path="/hello-worldbean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello World20");
	}

	@GetMapping(path="/hello-world/mypath/{name}")
	
	public HelloWorldBean helloWorldPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world,%s", name));
	}
	
}
