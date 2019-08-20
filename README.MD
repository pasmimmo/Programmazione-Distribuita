# Programmazione Distribuita aa 2018/2019
Benvenuti,
questa è la repo dove troverete tutti i sorgenti dei progetti svolti durante il corso di programmazione distribuita 
tenuto dal prof. **[Vittorio Scarano](https://docenti.unisa.it/001717/home)**  durante l'anno accademico 2018/2019 presso l'*Università Degli Studi di Salerno*, gruppo matricole pari.
## Argomenti del corso
* Architetture Distribuite
* Java Remote Method Invocation (JRMI)
* Design Pattern
* Java Enterprice Edition 7 (JEE7)
    * Enterprice Java Bean
    * Context and Dependency Injection
    * Java Persistence API
        * JPQL
        * Managed Persistence Context
    * Container-Side event
    * Interceptors
    * JavaEE Decorator
    * Web Services (SOAP)

## Libri di riferimento:
* [Programmazione con Oggetti Distribuiti: Java RMI](http://ilmiolibro.kataweb.it/libro/informatica-e-internet/36104/programmazione-con-oggetti-distribuiti-java-rmi-2/)
* [Beginning Java EE7](https://www.amazon.it/Beginning-Java-EE-Antonio-Goncalves/dp/143024626X)

## Struttura della Repo:
* ### Java RMI
    contiene tutti i sorgenti di Remote Method Invocation, attenzione perchè la Parte di RMI è un vecchio progetto i cui sorgenti risalgono al 2016, ne ho testato qualcuno a campione,  *Dovrebbero Funzionare*
    #### IDE, JDK e sistema di riferimento:
       Ubuntu 18.06 LTS
       Oracle JDK 8.121
       Eclipse Neon Java (non la versione EE)
* ### Java EE 7
    Contiene i sorgenti, appunto, inerenti a JEE7, testati e usati per l'esame.
    #### IDE, JDK, sistema e App Server di riferimento:
        Ubuntu 18.06 LTS
        Oracle JDK 8.121
        Netbeans ee 8.2 
        Payara 4.1.2.187 come appContainer (è un AppServer basato su GlassFish vedi sezione note)
## Autori:
* [**Domenico Pascucci**](https://github.com/pasmimmo) - *Modifica e adattamento dei codici originari*
* [Vittorio Scarano](https://docenti.unisa.it/001717/home) - *autore originario per la parte di JRMI*
* [Antonio Goncalves](https://github.com/agoncal) - *autore originario per la parte di JEE7*
## Note:
* [Payara](https://www.payara.fish/), è un AppServer basato su GlassFish e perfettamente compatibile con quest'ultimo. Dato lo stato di abandonware di GlassFish (con innumerevoli bug) sono stato costretto e felice di ripiegara su Payara in quanto la sua community continua lo sviluppo e il debug di questo AppServer di riferimento per JavaEE
* JDK e cambio Policy Oracle, vi consiglio di seguire [il mio blog](http://www.pasmimmo.altervista.org), dove ho riportato un po' di guide per far funzionare il tutto.
## Licenza:
Questo progetto è concesso in licenza con la licenza GNU GPL v3 - vedere il file LICENSE.md per i dettagli.
