package telran.spring.controller;

import org.springframework.web.bind.annotation.*;
GreetingsService greetingsService;


@RestController
@RequestMapping ("greetings")
@RequiredArgsConstructor

public class GreetingsController {
	final GreetingsService greetingsService;
	@GetMapping("{id}")
  String getGreetings(@PathVariable long id) {
	  return greetingsService.getGreetings(id);
  }
}
