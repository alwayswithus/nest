package com.douzone.nest.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@EnableAsync
@Controller("sse-data-controller")
@RequestMapping("/api/sse/notifications")
public class SSEController {


	private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();


	public SSEController() {

	}


	@GetMapping("/issue.json")
	public SseEmitter handle() { 
		final SseEmitter emitter = new SseEmitter(3000L);

		this.emitters.add(emitter); 

		emitter.onCompletion( new Runnable() {
			public void run() {
				System.out.println("시작...");
				emitters.remove(emitter); 
			}
		}); 

		emitter.onTimeout( new Runnable() {
			public void run() {
				emitters.remove(emitter);
			}
		});

		return emitter;
	}

	@Async
	@EventListener
	public void onIssueStateChangeEvent(String event) {
		List<SseEmitter> deadEmitters = new ArrayList<>();
		for(SseEmitter emitter : emitters ) { 
			try {
				emitter.send(event);
			} catch (Exception e) {
				deadEmitters.add(emitter);
			}     
		}
		this.emitters.removeAll(deadEmitters);
	} 
}