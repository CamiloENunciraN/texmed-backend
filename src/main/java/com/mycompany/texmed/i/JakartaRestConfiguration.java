package com.mycompany.texmed.i;

import com.mycompany.texmed.i.resources.ClienteResource;
import com.mycompany.texmed.i.resources.CorsFilter;
import com.mycompany.texmed.i.resources.MedidaResource;
import com.mycompany.texmed.i.resources.UsuarioResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilter.class);
        classes.add(UsuarioResource.class);
        classes.add(ClienteResource.class);
        classes.add(MedidaResource.class);
        return classes;
    }
}
