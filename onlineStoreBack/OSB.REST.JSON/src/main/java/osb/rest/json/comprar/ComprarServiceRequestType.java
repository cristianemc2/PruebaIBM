//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.14 at 10:35:52 PM COT 
//


package osb.rest.json.comprar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComprarServiceRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComprarServiceRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comprarRQ" type="{http://www.portobella.com/onlineStore/services/Comprar}ComprarRQType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComprarServiceRequestType", propOrder = {
    "comprarRQ"
})
public class ComprarServiceRequestType {

    @XmlElement(required = true)
    protected ComprarRQType comprarRQ;

    /**
     * Gets the value of the comprarRQ property.
     * 
     * @return
     *     possible object is
     *     {@link ComprarRQType }
     *     
     */
    public ComprarRQType getComprarRQ() {
        return comprarRQ;
    }

    /**
     * Sets the value of the comprarRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComprarRQType }
     *     
     */
    public void setComprarRQ(ComprarRQType value) {
        this.comprarRQ = value;
    }

}