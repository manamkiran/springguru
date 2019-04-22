package spring.joke.jokeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import spring.joke.jokeapp.services.JokeService;

@Controller
public class JokeController {

	private JokeService jokeService;

	@Autowired
	public JokeController(JokeService jokeService) {
		this.jokeService = jokeService;
	}

	@GetMapping("/")
	public String getRandomJoke(Model model) {
		model.addAttribute("randomJoke", jokeService.getJoke());
		return "randomJoke";
	}

}
