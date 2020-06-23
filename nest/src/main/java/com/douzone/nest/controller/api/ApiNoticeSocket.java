package com.douzone.nest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Controller
public class ApiNoticeSocket {
	
//	@Autowired
	private final SimpMessagingTemplate template;
	
	@Autowired
	public ApiNoticeSocket(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	@MessageMapping("/asnotice") // react -> spring 송신
//	@SendTo("topic/asnotice")	// spring -> react 송신
	public void send(Object socketData) {
		try{
			System.out.println("작동");
			System.out.println(socketData);
			template.convertAndSend("/topic/asnotice", socketData);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	@EventListener
	public void connt(SessionDisconnectEvent e) {
		System.out.println(e);
		System.out.println("소켓 종료");
	}
}
