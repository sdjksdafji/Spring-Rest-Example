package spring.rest.example;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
//@RequestMapping("/rest")
public class HomeController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	public HomeController() {
		super();
		System.out.println("-----------------------------> Init");
	}

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("-----------------------------> Handle");
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

	@RequestMapping("/")
	public String greeting2() {
		System.out.println("-----------------------------> Handle");
		return "12341234";
	}
}