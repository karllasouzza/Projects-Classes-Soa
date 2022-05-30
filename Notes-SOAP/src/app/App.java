package app;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;

public class App {
    public static void main(String[] args) throws Exception {
		//Interface gráfica do servidor
		JFrame frame = new JFrame();	
		frame.setTitle("Jetty");
		frame.setPreferredSize(new Dimension(180, 180));
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel();
		label.setText("Jetty em execução!");
		label.setBounds(15, 15, 160, 100);
		frame.add(label);						   	
    	
    	//Servidor
    	final ResourceConfig application = new ResourceConfig()
    			.packages("wsrest")
    			.register(JacksonFeature.class);
    	application.register(new CORSFilter());
    	
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(9000);
        jettyServer.setHandler(context);
        
        ServletHolder jerseyServlet = new ServletHolder(new
                org.glassfish.jersey.servlet.ServletContainer(application));
        jerseyServlet.setInitOrder(0);
        context.addServlet(jerseyServlet, "/*");        
        
        frame.setVisible(true);
        
        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }     
    }
}
