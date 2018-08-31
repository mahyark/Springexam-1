package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

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
    }

    public void whenBtnGetAllQuotes_click(ActionEvent actionEvent) {
        //System.out.println("Find all: ") ;
    	final StringBuilder output = new StringBuilder();
        repository.findAll().forEach(quote -> output.append(quote.getQuoteDescription() + "\n"));
        JOptionPane.showMessageDialog(null, output);
    }

    public void whenBtnGetByKeyword_click(ActionEvent actionEvent) {
    	final StringBuilder output = new StringBuilder();
		String keyword = ui.getKeyword().getText();
		
        repository.findAll().forEach(quote -> quote.getQuoteDescription().contains(keyword));   
        for (Quote q : repository.findAll()) {
        	if (q.getQuoteDescription().contains(keyword)) {
                output.append(q.getQuoteDescription() + "\n");
			}
        }
        
        if (output.length() < 0) {
            JOptionPane.showMessageDialog(null, "No quote found!");
		}
        else {
            JOptionPane.showMessageDialog(null, output);
        }
    }
}
