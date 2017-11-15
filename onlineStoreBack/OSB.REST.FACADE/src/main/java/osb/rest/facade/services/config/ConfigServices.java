/**
 * 
 */
package osb.rest.facade.services.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author Cristian Martinez
 *
 */
public class ConfigServices extends Application {

    /**
     * Metodo para agregar Interfaces de Servicios Rest.
     */
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(osb.rest.facade.services.ComprarServiceREST.class);

        return classes;
    }
}
