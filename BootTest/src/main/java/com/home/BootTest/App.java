package com.home.BootTest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@SpringBootApplication
public class App {
	@RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String home() {
		return "Nothing here. Go to <a href='/sample'>/sample</a>";
	}

	@RequestMapping("/sample")
	public Map<String, String> sample(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", String.format("Hello, %s", name));
		return result;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}