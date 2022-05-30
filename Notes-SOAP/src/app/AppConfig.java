package app;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("wsrest");    
    }    
}