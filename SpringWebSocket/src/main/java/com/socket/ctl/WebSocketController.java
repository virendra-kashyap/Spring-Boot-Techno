package com.socket.ctl;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socket.model.Greeting;
import com.socket.model.HelloMessage;

public class WebSocketController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) {
		return new Greeting("Hello, " + message.getName() + "!");
	}

}
