package com.web.common.listner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextTestListner
 *
 */
@WebListener
public class ServletContextTestListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextTestListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("서버종료");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("서버생성");
    	
    	ServletContext context = sce.getServletContext();
    	System.out.println(context.getContextPath());
    	
    	String javahome=System.getenv("JAVA_HOME");
    	System.out.println(javahome);
    }
	
}
