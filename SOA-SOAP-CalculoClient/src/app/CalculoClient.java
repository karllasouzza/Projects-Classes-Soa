package app;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import wsinterface.ICalculo;


public class CalculoClient {
	public static void main(String[] args) {
		try {
			
		URL url = new URL("http://localhost:5000/calculo?wsdl");
		
		QName qname = new QName("http://ws/","CalculoService");
		
		Service service = Service.create(url, qname);
		
		ICalculo calculo = service.getPort(ICalculo.class);
		System.out.print(calculo.adicionar(12, 6));
		
	
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
