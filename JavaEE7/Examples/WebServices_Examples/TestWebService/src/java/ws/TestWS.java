/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author pasmimmo
 */
@WebService(serviceName = "TestWS")
@Stateless
public class TestWS {

    /**
     * This is a sample web service operation
     * @param name
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(
            @XmlElement(required = true)
            @WebParam(name = "name") String name) {
        return "Hello " + name + " !";
    }

    /**
     * Web service operation
     * @param firstName
     * @param lastName
     * @return 
     */
    @WebMethod(operationName = "regards")
    public String salutoFormale(@WebParam(name = "first_name") String firstName, @WebParam(name = "last_name") String lastName) {
        //TODO write your implementation code here:
        return "Regards, Mr "+lastName;
    }
}
