package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quote {

	@Id
    @GeneratedValue
    private Long id;

    @Column
    private String quoteDescription;

	public Quote() {}
	
    public Quote(String quoteDesc) {
	    this.quoteDescription = quoteDesc;
    }

	public String getQuoteDescription() {
		return quoteDescription;
	}

	public void setQuoteDescription(String quoteDescription) {
		this.quoteDescription = quoteDescription;
	}
	   
    @Override
    public String toString() {
        return "Quote{Description: " + this.quoteDescription + "}";
    } 
}
