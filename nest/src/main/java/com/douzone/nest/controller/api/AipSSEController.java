package com.douzone.nest.controller.api;

import java.time.Duration;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


/// 아직 작업중 공사중 건들지마세요!!!!!!!
@RestController
public class AipSSEController {
	@GetMapping("/api/sse/notice")
	public Flux<ServerSentEvent<String>> stocks(/*@PathVariable("code") String code*/) {

		System.out.println("반응???");
		Flux<ServerSentEvent<String>> a;
		a = Flux.interval(Duration.ofSeconds(2))
				.map(t -> ServerSentEvent.builder("이거 받을수 있음?").build());
		
		//a = Flux.

		return a;
		//        return Flux.interval(Duration.ofSeconds(1))
		//                .map(t -> Stock.builder()
		//                        .code(code)
		//                        .value(randomValue())
		//                        .build())
		//                .map(stock -> ServerSentEvent.builder(stock).build());
	}

	//    private int randomValue() {
	//        return ThreadLocalRandom.current().nextInt(1000) + 10000;
	//    }
}
