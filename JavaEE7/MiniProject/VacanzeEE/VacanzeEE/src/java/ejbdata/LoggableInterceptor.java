/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author pasmimmo
 */
@Interceptor
@Loggable
public class LoggableInterceptor {

    Logger logger;

    /**
     * metodo di logger che intercetta e stampa a video 
     * i metodi richiamati da tutta la classe
     * 
     * ATTENZIONE
     * Deve essere dichiarato nel bean.xml
     * @param context
     * @return
     * @throws Exception
     */
    @AroundInvoke
    public Object stampaAccessi(InvocationContext context) throws Exception {
        logger = Logger.getLogger("");
        String loggerString = "il metodo " + context.getMethod().toString() + " e stato acceduto";
        logger.info(loggerString);
        return context.proceed();
    }
}
