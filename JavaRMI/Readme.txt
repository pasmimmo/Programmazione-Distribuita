Benvenuti, sono Domenico Pascucci, e questa è la directory dove troverete tutti i sorgenti 
dei progetti svolti durante il corso di programmazione distribuita 
tenuto dal prof. Vittorio Scarano nell'anno accademico 2016/2017 
presso l'Università Degli Studi di Salerno, gruppo matricole pari.


Affinche i programmi "girino" dovete settare le policy della JVM, 
ho allegato un file test(permette tutto) chiamato java.policy 
che dovrete copiare in C: e successivamente caricarlo 
aggiungendo le seguenti opzioni alla vostra JVM(senza apici"):
"-Djava.security.manager -Djava.security.policy=C:/java.policy" 

Riporto di seguito la legenda delle sigle utilizzate per i nomi 

[RMI]		Java Remote Metod Invocation.
[DP]		Design Pattern.
[Socket]	Socket.
[IIOP]		RMI su protocollo Orb di CORBA.
[Thread]	Multi-Threading: esecuzioni concorrenti 
#########################################################################################

Ringrazio il Prof. Vittorio Scarano per avermi dato l'autorizzazione ad usare/distribuire i sorgenti contenuti nel suo libro:
http://ilmiolibro.kataweb.it/libro/informatica-e-internet/36104/programmazione-con-oggetti-distribuiti-java-rmi-2/




<hr>
java -Djava.security.manager -Djava.security.policy=C:/java.policy -jar _PD__DesignPattern_Adapter.jar
