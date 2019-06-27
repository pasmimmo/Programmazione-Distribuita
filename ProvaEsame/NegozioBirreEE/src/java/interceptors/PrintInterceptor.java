/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author pasmimmo
 */
@Interceptor @LogMethod
public class PrintInterceptor {
    //@updated aggiunto un interceptorBinding
    static int nOfInvocation=0;
    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception
    {
        nOfInvocation++;
        System.out.println("il metodo "+ic.getMethod().getName() + "e stato acceduto "+nOfInvocation +" volte");
        return ic.proceed();
    }
}
