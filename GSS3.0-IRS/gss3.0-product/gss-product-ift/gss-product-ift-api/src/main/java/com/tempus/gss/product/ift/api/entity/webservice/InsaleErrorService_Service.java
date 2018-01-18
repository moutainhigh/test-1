
package com.tempus.gss.product.ift.api.entity.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "InsaleErrorService", targetNamespace = "http://tempusservice.tempus.com", wsdlLocation = "http://172.16.3.242:8080/accounts/ws/insaleErrorService?wsdl")
public class InsaleErrorService_Service
    extends Service
{

    private final static URL INSALEERRORSERVICE_WSDL_LOCATION;
    private final static WebServiceException INSALEERRORSERVICE_EXCEPTION;
    private final static QName INSALEERRORSERVICE_QNAME = new QName("http://tempusservice.tempus.com", "InsaleErrorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.16.3.242:8080/accounts/ws/insaleErrorService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INSALEERRORSERVICE_WSDL_LOCATION = url;
        INSALEERRORSERVICE_EXCEPTION = e;
    }

    public InsaleErrorService_Service() {
        super(__getWsdlLocation(), INSALEERRORSERVICE_QNAME);
    }

    public InsaleErrorService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), INSALEERRORSERVICE_QNAME, features);
    }

    public InsaleErrorService_Service(URL wsdlLocation) {
        super(wsdlLocation, INSALEERRORSERVICE_QNAME);
    }

    public InsaleErrorService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INSALEERRORSERVICE_QNAME, features);
    }

    public InsaleErrorService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InsaleErrorService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns InsaleErrorService
     */
    @WebEndpoint(name = "InsaleErrorServicePort")
    public InsaleErrorService getInsaleErrorServicePort() {
        return super.getPort(new QName("http://tempusservice.tempus.com", "InsaleErrorServicePort"), InsaleErrorService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InsaleErrorService
     */
    @WebEndpoint(name = "InsaleErrorServicePort")
    public InsaleErrorService getInsaleErrorServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempusservice.tempus.com", "InsaleErrorServicePort"), InsaleErrorService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INSALEERRORSERVICE_EXCEPTION!= null) {
            throw INSALEERRORSERVICE_EXCEPTION;
        }
        return INSALEERRORSERVICE_WSDL_LOCATION;
    }

}
