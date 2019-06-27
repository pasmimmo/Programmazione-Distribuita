/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author pasmimmo
 */
@Interceptor
public class logInterceptor {
    Logger logger= Logger.getLogger("Interceptor_Logger: ");
    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception{
        logger.info(ic.getMethod().getName() + "e' stato invocato");
        return ic.proceed();
    }
    
}
