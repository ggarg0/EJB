package com.gaurav.sessionBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.gaurav.InterceptorDAO.SimpleInterceptor;

/**
 * Session Bean implementation class SessionBean
 */
@Stateful(mappedName="/BeanDemo")
@Interceptors(SimpleInterceptor.class)
public class SessionBean implements SessionBeanRemote, SessionBeanLocal {

    /**
     * Default constructor. 
     */
    public SessionBean() {
       
    }
    @PreDestroy
    public void PreDestroy()
    {
    	System.out.println(" Executing method : @@PreDestroy");;
    }
    
    @PostConstruct 
    public void PostConstruct() {
     System.out.println("Invoking method: PostConstruct ()");  
    }
    
    
   
	@Override
	public String LocalBeanCall(String param) {
		System.out.println(" Executing method : LocalBeanCall");

		return "Local Bean";
	}

	@Override
	public String RemoteBeanCall(String param) {
		System.out.println(" Executing method : RemoteBeanCall");

		return "Remote Bean";
	}
	@Remove
	public void RemoveSesssion() {
		   System.out.println("Invoking method: Remove ()");  
		
	}
	


}
