package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventHandler {

    private UI ui;
    private QuoteRepository repository;
    
    @Autowired
    public void setRepository(QuoteRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenBtnQuotes_click(ActionEvent actionEvent) {
		String fileName = "oscar_wilde.txt";

        try {
			List<String> quotes = Files.lines(Paths.get(fileName))
											.filter(line -> !line.startsWith(" "))
											.collect(Collectors.toList());

			String tmp = "";
			for (String q : quotes) {
				if (!q.isEmpty()) {
					tmp += " " + q;
				}
				else {
					repository.save(new Quote(tmp));
					tmp = "";
				}
			}
			
			System.out.println("");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

        System.out.println("Find all: ") ;
        repository.findAll().forEach(System.out::println);
    }
}
