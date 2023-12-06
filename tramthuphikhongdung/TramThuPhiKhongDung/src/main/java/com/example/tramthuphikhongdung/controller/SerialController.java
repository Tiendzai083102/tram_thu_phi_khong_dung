package com.example.tramthuphikhongdung.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;



@Controller
public class SerialController {


	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String greeting() throws Exception {
		Thread.sleep(1000); // simulated delay
		return "hello";
	}

}