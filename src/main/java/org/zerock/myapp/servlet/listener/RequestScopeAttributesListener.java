package org.zerock.myapp.servlet.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@NoArgsConstructor

@WebListener
public class RequestScopeAttributesListener 
      implements ServletRequestAttributeListener {
   
   
   private boolean printAttrInfo(
         ServletRequestAttributeEvent event) {
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
          ServletRequestAttributeEvent event)  { 
      if(this.printAttrInfo(event)) return;
      
      log.debug("attributeAdded(event) invoked");
      
    } // attributeAdded
   
    @Override
    public void attributeRemoved(
          ServletRequestAttributeEvent event)  {
      if(this.printAttrInfo(event)) return; 
       
       log.debug("attributeRemoved(event) invoked");
    } // attributeRemoved

   @Override
    public void attributeReplaced(
          ServletRequestAttributeEvent event)  { 
      if(this.printAttrInfo(event)) return;
      
      log.debug("attributeReplaced(event) invoked");
    } // attributeReplaced
   
} // end class