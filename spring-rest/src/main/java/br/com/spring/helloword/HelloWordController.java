package br.com.spring.helloword;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
	private AtomicLong atomicLong = new AtomicLong();
	
	@GetMapping("/hello")
	public HelloWord get(
			@RequestParam(value = "name", defaultValue = "world") String name) {
		
		return new HelloWord(atomicLong.incrementAndGet(), String.format("Hello %s!", name));
	}
	
}