package hello.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDups {

	public static void main(String[] args) {
		//Set<String> distinctWords = Arrays.asList(args).stream().collect(Collectors.toSet());
		//System.out.println(distinctWords.size() + " distinct words: "+ distinctWords);
		Set<String> words = new HashSet<String>();
		for(String s : args) {
			words.add(s);
		}
		System.out.println(words.size() + " distinct words: " + words);
	}
}
