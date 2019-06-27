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
public class TuttiIViaggiInterceptor {

    static int nOfInvocation = 0;
    Logger logger;

    /**
     *Metodo che intercetta solo il metodo stampaTuttiIViaggi() della classe ViaggioEJB
     * @param context
     * @return
     * @throws Exception
     */
    @AroundInvoke
    public Object stampaAccessi(InvocationContext context) throws Exception {
        nOfInvocation++;
        logger = Logger.getLogger("");
        String loggerString = "il metodo " + context.getMethod().toString() + " e stato acceduto " + nOfInvocation + " volte";
        logger.info(loggerString);
        return context.proceed();
    }
}
