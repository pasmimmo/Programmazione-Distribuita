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
@Interceptor
public class Director {
    
    @AroundInvoke
    public Object initercept(InvocationContext ic) throws Exception{
        System.out.println("Diretore Cambiato");
        return ic.proceed();
    }
    
}
