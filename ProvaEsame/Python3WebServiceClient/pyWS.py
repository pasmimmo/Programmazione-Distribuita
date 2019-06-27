from zeep import Client

client = Client('http://localhost:8080/NegozioEJBService/NegozioWS?WSDL')
print("Cambiamo il  nome del Direttore")
oldName=input("inserisci il vecchio nome: ")
newNome=input("dammi nuovo nome: ")
print(client.service.cambio_direttore(oldName, newNome))