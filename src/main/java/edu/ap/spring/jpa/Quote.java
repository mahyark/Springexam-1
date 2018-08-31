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
    
    @Column
    private String tagName;

	public Quote() {}
	
    public Quote(String quoteDesc, String tag) {
	    this.quoteDescription = quoteDesc;
	    this.tagName = tag;
    }

	public String getQuoteDescription() {
		return quoteDescription;
	}

	public void setQuoteDescription(String quoteDescription) {
		this.quoteDescription = quoteDescription;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = quoteDescription;
	}
	   
    @Override
    public String toString() {
        return "Quote{Description: " + this.quoteDescription + ", Tag: " + this.tagName + "}";
    } 
}
