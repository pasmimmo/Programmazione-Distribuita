/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author pasmimmo
 */
@Interceptor
public class MouseInterceptor {
    
    static int count = 0;
    
    @AroundInvoke
    private Object log(InvocationContext c) throws Exception{
        System.out.println("Ho invocato il metodo: "+c.getMethod().getName()+" "+count+" volte");
        return c.proceed();
    }
}
