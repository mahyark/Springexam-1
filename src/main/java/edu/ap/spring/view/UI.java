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
	private JPanel controlPanel;
    private JButton btnAddUser;
    
    public UI() {}
    
    public void setupUI() {
    	jFrame = new JFrame("Spring Exam 1");
    	jFrame.setLayout(new FlowLayout());
	    	
    	controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));
		
		btnAddUser = new JButton();
		btnAddUser.setText("Get quotes");
		btnAddUser.setTransferHandler(new TransferHandler("text"));
		btnAddUser.addActionListener(eventHandler::whenBtnQuotes_click);

		controlPanel.add(btnAddUser);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(800, 800);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JButton getButton() {
        return btnAddUser;
    }
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
