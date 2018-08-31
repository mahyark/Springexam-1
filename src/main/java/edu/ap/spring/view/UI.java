package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;

	private JFrame jFrame;
	private JLabel label1, label2;
	private JTextField keyword;
	private JPanel controlPanel;
    private JButton btnGetQuotes;
    private JButton btnGetByKeyword;
    private JButton btnGetAllQuotes;
    
    public UI() {}
    
    public void setupUI() {
    	jFrame = new JFrame("Spring Exam 1");
    	jFrame.setLayout(new FlowLayout());
	    	
    	controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(6, 5));
	    
		btnGetQuotes = new JButton();
		btnGetQuotes.setText("Get quotes from file");
		btnGetQuotes.setTransferHandler(new TransferHandler("text"));
		btnGetQuotes.addActionListener(eventHandler::whenBtnQuotes_click);
	    
		btnGetAllQuotes = new JButton();
		btnGetAllQuotes.setText("Get all quotes");
		btnGetAllQuotes.setTransferHandler(new TransferHandler("text"));
		btnGetAllQuotes.addActionListener(eventHandler::whenBtnGetAllQuotes_click);
	    
		btnGetByKeyword = new JButton();
		btnGetByKeyword.setText("Get quote by keyword");
		btnGetByKeyword.setTransferHandler(new TransferHandler("text"));
		btnGetByKeyword.addActionListener(eventHandler::whenBtnGetByKeyword_click);

		label1 = new JLabel("Search for a quote by a word it contains.");
		label2 = new JLabel("Keyword: ");
		keyword = new JTextField(30);
		keyword.setDragEnabled(true);
		
		controlPanel.add(btnGetQuotes);
		controlPanel.add(btnGetAllQuotes);
		
		controlPanel.add(label1);
		controlPanel.add(label2);
		controlPanel.add(keyword);
		controlPanel.add(btnGetByKeyword);
		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JButton getButton() {
        return btnGetQuotes;
    }
    
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
