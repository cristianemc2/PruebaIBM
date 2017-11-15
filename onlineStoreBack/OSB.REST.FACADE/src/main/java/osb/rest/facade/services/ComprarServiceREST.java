package osb.rest.facade.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import osb.rest.business.ejb.ComprarServiceBean;
import osb.rest.json.comprar.ComprarServiceRequestType;
import osb.rest.json.comprar.ComprarServiceResponseType;

/*
 * La clase ComprarServiceREST ofrece la publicacion del metodo realizarCompra mediante REST para ser consumido por terceros.
 * 
 * @author Cristian Martinez
 */
@javax.ws.rs.Path("/services/public/PortobellaService")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComprarServiceREST {

    @EJB
    ComprarServiceBean comprarServiceBean;

    /**
     * Metodo que sirve de fachada y exponer la logica de negocio como servicio
     * REST.
     * 
     * @param comprarServiceRequestType
     * @return
     */
    @Path("/realizarCompra")
    @javax.ws.rs.POST
    public ComprarServiceResponseType realizarCompra(
            ComprarServiceRequestType comprarServiceRequestType) {

        ComprarServiceResponseType comprarServiceResponseType = this.comprarServiceBean
                .realizarCompra(comprarServiceRequestType);

        return comprarServiceResponseType;
    }

}
