package org.zerock.myapp.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@WebListener
public class ApplicationsScopeAttributesListener 
			implements ServletContextAttributeListener {
	
	private boolean printAttrInfo(
    		ServletContextAttributeEvent event) {
		if(
	        	event.getName().startsWith("org.springframework") ||
	        	event.getName().startsWith("org.apache") ||
	        	event.getName().startsWith("javax.servlet") ||
	        	event.getName().endsWith(".FILTERED")
	        	) {
	        	 	return true;
	         } // if
	         
	         String name = event.getName();
	         Object value = event.getValue();
	         
	         log.info("\t+ name: " + name);
	         log.info("\t+ value: " + value);
	         
	         return false;
	} // printAttrInfo
	
	@Override
    public void attributeAdded(
    		ServletContextAttributeEvent event)  { 
		 if(this.printAttrInfo(event)) return;
         log.info("attributeAdded(event) invoked.");
         
         
    } // attributeAdded

	@Override
    public void attributeRemoved(
    		ServletContextAttributeEvent event)  { 
		
		log.info("attributeRemoved(event) invoked.");
		
		if(this.printAttrInfo(event)) return;
    } // attributeRemoved

    public void attributeReplaced(
    		ServletContextAttributeEvent event)  { 
    	
    	log.info("attributeReplaced(event) invoked.");
    	
    	if(this.printAttrInfo(event)) return;
    } // attributeReplaced
	
} // end class
