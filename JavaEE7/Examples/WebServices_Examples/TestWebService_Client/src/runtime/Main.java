/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

/**
 *
 * @author pasmimmo
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nella WS di saluto, formale ed informale");
        System.out.println("saluto informale output:\n\t\t"+hello("Mimmo"));
        System.out.println("saluto formale output:\n\t\t"+regards("Domenico", "Pascucci"));
        
    }

    private static String hello(java.lang.String name) {
        ws.TestWS_Service service = new ws.TestWS_Service();
        ws.TestWS port = service.getTestWSPort();
        return port.hello(name);
    }

    private static String regards(java.lang.String firstName, java.lang.String lastName) {
        ws.TestWS_Service service = new ws.TestWS_Service();
        ws.TestWS port = service.getTestWSPort();
        return port.regards(firstName, lastName);
    }
    
    
}
