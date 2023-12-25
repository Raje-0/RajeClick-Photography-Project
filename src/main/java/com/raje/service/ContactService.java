package com.raje.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raje.entity.Contact;
import com.raje.springJDBC_repository.ContactRepository;
import com.raje.springJDBC_repository_contants.RajeClickConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j // private static Logger log =LoggerFactory.getLogger(ContactService.class);

//@RequestScope
//@SessionScope
//@ApplicationScope
@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// web scope
	/*
	 * private int counter = 0; public int getCounter() { return counter; }
	 * 
	 * public void setCounter(int counter) { this.counter = counter; }
	 */
	/**
	 * Save Contact Details into DB
	 * 
	 * @param contact
	 * @return boolean
	 */
	public boolean saveMessageDetails(Contact contact) {
		boolean isSaved = false;
		contact.setStatus(RajeClickConstants.OPEN);
		contact.setCreatedBy(RajeClickConstants.ANONYMOUS);
		contact.setCreatedAt(LocalDateTime.now());
		int result = contactRepository.saveContactMsg(contact);
		if (result > 0) {
			isSaved = true;
		}
		return isSaved;
	}

	public List<Contact> findMsgsWithOpenStatus() {
		List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(RajeClickConstants.OPEN);
		return contactMsgs;
	}

	public boolean updateMsgStatus(int contactId, String updatedBy) {
		boolean isUpdated = false;
		int result = contactRepository.updateMsgStatus(contactId, RajeClickConstants.CLOSE, updatedBy);
		if (result > 0) {
			isUpdated = true;
		}
		return isUpdated;
	}

}
