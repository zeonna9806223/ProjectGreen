package _00_init.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SystemInitListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext ctx = sce.getServletContext();
    	GlobalService  service = new GlobalService();
    	// 把整個GlobalService當作屬性物件，放到getServletContext裡面
    	ctx.setAttribute("SYSTEM", service);
    }	
}
