package listener;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author test
 */
public class init implements ServletContextListener {
    
    private Connection conn;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try{
            conn = getCoworking_db().getConnection();
            arg0.getServletContext().setAttribute("connection", conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            conn.close(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private DataSource getCoworking_db() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/coworking_db");
    }
}
