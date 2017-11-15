package osb.rest.business.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import osb.rest.common.exception.PortobellaException;
import osb.rest.common.util.CommonUtil;
import osb.rest.common.util.Constant;
import osb.rest.json.comprar.ComprarRSType;
import osb.rest.json.comprar.ComprarServiceRequestType;
import osb.rest.json.comprar.ComprarServiceResponseType;

/**
 * Session Bean implementation class ComprarServiceBean
 */
@Stateless(mappedName = "ComprarServiceBean")
@LocalBean
public class ComprarServiceBean {

    private Logger logger;

    /**
     * Metodo que se ejecuta despues que el contenedor de EJB a creado una
     * instancia del EJB.
     */
    @PostConstruct
    public void init() {
        logger = LoggerFactory.getLogger(ComprarServiceBean.class);
    }

    /**
     * Metodo que tiene la logica de negocio para la operacion de realizar
     * compra.
     * 
     * @param comprarServiceRequestType
     * @return
     */
    public ComprarServiceResponseType realizarCompra(
            ComprarServiceRequestType comprarServiceRequestType) {

        ComprarServiceResponseType comprarServiceResponseType;
        String comprarServiceResponseTypeString;
        String comprarServiceRequestTypeString;

        try {

            this.logger.trace(Constant.METHOD_INICIO_REALIZAR_COMPRAR);

            // Imprime en consola el JSON que le llega
            comprarServiceRequestTypeString = CommonUtil
                    .castJSONToString(comprarServiceRequestType);

            this.logger.debug(comprarServiceRequestTypeString);

            // Construye un objeto de rspuesta JSON para retornar.
            comprarServiceResponseType = this
                    .buildComprarServiceResponseType(Boolean.TRUE.toString());

            // La respuesta es casteada a String para posteriormente ser
            // imprimida en consola.
            comprarServiceResponseTypeString = CommonUtil
                    .castJSONToString(comprarServiceResponseType);

            this.logger.trace(Constant.METHOD_FIN_REALIZAR_COMPRAR);

        } catch (PortobellaException e) {

            this.logger.error(Constant.ERROR_METHOD_REALIZAR_COMPRAR, e);

            comprarServiceResponseType = this
                    .buildComprarServiceResponseType(Boolean.FALSE.toString());

            // La respuesta es casteada a String para posteriormente ser
            // imprimida en consola.
            comprarServiceResponseTypeString = this
                    .castJSONToString(comprarServiceResponseType);

        }

        // Imprime en consola el JSON que se retorna
        this.logger.debug(comprarServiceResponseTypeString);

        // Retornamos el Objeto JSON de Respuesta
        return comprarServiceResponseType;
    }

    /**
     * Metodo que construye un objeto de respuesta JSON
     * ComprarServiceResponseType.
     * 
     * @param isError
     * @return
     */
    private ComprarServiceResponseType buildComprarServiceResponseType(
            String isError) {

        ComprarServiceResponseType comprarServiceResponseType;
        ComprarRSType comprarRSType;

        comprarServiceResponseType = new ComprarServiceResponseType();
        comprarRSType = new ComprarRSType();
        comprarRSType.setIsError(isError);
        comprarServiceResponseType.setComprarRS(comprarRSType);

        return comprarServiceResponseType;

    }

    /**
     * Metodo que encapsula exception PortobellaException
     * 
     * @param comprarServiceResponseType
     * @return
     */
    private String castJSONToString(Object comprarServiceResponseType) {

        try {
            // La respuesta es casteada a String para posteriormente ser
            // imprimida en consola.
            return CommonUtil.castJSONToString(comprarServiceResponseType);

        } catch (PortobellaException e) {

            this.logger.error(Constant.ERROR_METHOD_REALIZAR_COMPRAR, e);
        }

        return Constant.COMMON_STRING_EMPTY;

    }
}
