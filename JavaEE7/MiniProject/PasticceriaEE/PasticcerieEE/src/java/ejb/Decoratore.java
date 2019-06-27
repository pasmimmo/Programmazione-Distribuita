/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

/**
 *
 * @author pasmimmo
 */
@Decorator
@Priority(Interceptor.Priority.PLATFORM_BEFORE)
public class Decoratore implements Saluti{
    
    @Inject @Delegate @Any
    Saluti saluti;

    @Override
    public String salutami(String tuoNome) {
        System.out.println("sono nel decorator");
        return saluti.salutami(tuoNome)+" decorato";
    }
    
    
}
