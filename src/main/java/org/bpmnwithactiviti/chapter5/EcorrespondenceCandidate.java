package org.bpmnwithactiviti.chapter5;

import java.io.Serializable;
import java.util.Date;

public class EcorrespondenceCandidate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String subject;
	private String fromName;
	private String emailAddress;
	private Date receivedDate;
	private boolean isOfficial;
	private String recipient;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public boolean isOfficial() {
		return isOfficial;
	}
	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
}
