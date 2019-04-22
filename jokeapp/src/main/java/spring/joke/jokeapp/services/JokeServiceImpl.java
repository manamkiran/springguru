package spring.joke.jokeapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService{
	
	private final ChuckNorrisQuotes chuckNorrisQuotes;

	
	public JokeServiceImpl() {
		chuckNorrisQuotes = new  ChuckNorrisQuotes();
	}


	@Override
	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}

}
