package com.socket.ctl;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.socket.model.Greeting;
import com.socket.model.HelloMessage;

@Controller
public class WebSocketCtl {

	@GetMapping("/")
	public String index(Model model) {
		return "index.html";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000);
		return new Greeting("Hello, " + message.getName() + "!");
	}

}
