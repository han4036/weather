package org.zerock.myapp.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@NoArgsConstructor

@WebListener
public class SessionScopeAttributesListener 
			implements HttpSessionAttributeListener {
	
	
	private boolean printAttrInfo(
			HttpSessionBindingEvent event) {
		if(
	        	event.getName().startsWith("org.springframework") ||
	        	event.getName().startsWith("org.apache") ||
	        	event.getName().startsWith("javax.servlet") ||
	        	event.getName().endsWith(".FILTERED")
	        	) {
	        	 	return true;
	         } // if
	         HttpSession session = event.getSession();
	         String name = event.getName();
	         Object value = event.getValue();
	         
	         log.info("\t+ session: " + session.getId());
	         log.info("\t+ name: " + name);
	         log.info("\t+ value: " + value);
	         
	         return false;
	} // printAttrInfo
 
	@Override
    public void attributeAdded(
    		HttpSessionBindingEvent event)  { 
		if(this.printAttrInfo(event)) return;
    	log.info("attributeAdded(event) invoked.");
    	
    	
    } // attributeAdded

	@Override
    public void attributeRemoved(
    		HttpSessionBindingEvent event)  { 
		if(this.printAttrInfo(event)) return;
    	log.info("attributeRemoved(event) invoked.");
    	
    	
    } // attributeRemoved

	@Override
    public void attributeReplaced(
    		HttpSessionBindingEvent event)  { 
		if(this.printAttrInfo(event)) return;
    	log.info("attributeReplaced(event) invoked.");
    	
    	
    } // attributeReplaced
	
} // end class
