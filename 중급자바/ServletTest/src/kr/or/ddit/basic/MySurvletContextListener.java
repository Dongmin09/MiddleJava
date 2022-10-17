package kr.or.ddit.basic;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySurvletContextListener implements ServletContextListener 
												, ServletContextAttributeListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[MySurvletContextListener] contextDestroyed =>"
				+ sce);
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[MySurvletContextListener] contextInitialized =>"
				+ sce);
		
	}
	
	

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("[MySurvletContextListener] attributeAdded =>"
				+ event.getName() + "추가됨..");
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("[MySurvletContextListener] attributeRemoved =>"
				+ event.getName() + "삭제됨..");
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("[MySurvletContextListener] attributeReplaced =>"
				+ event.getName() + "변경됨..");
		
	}

}
