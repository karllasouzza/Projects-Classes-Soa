package app;

import javax.xml.ws.Endpoint;

import ws.Calculo;

public class Aplicacao {
	
	public static void main(String[] args) {
		System.out.println("WebService SOAP Cálculo");
		Endpoint.publish("http://localhost:5000/calculo", 
				new Calculo());
	}
}
