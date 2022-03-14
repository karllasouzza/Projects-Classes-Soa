package app;

import javax.xml.ws.Endpoint;

import ws.Traducao;

public class Aplicacao {

	public static void main(String[] args) {
		System.out.println("serviço iniciado");
		Endpoint.publish("http://localhost:8000/traducao", new Traducao());
	}
}
