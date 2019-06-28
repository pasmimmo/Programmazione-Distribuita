/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * Qualificatore, un nome che viene legato alla classe che lo "implementa", per il logger
 * il concetto di qualificatore si basa sul concetto di 
 * ->StrongTyping
 * mentre il codice viene compilato, 
 * viene effettuata la verifica dell'esistenza dello stesso e di eventuali errori di battitura
 * ->LooseCoupling (basso accoppiamento)
 * ovvero se vogliamo sostituire la classe che "implementa"  il qualificatore, 
 * ci basta cambiare il codice solo in quella classe
 *  
 * @author pasmimmo
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface LoggerInjectable {
}
