package app;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import wsinterface.ITraducao;

public class TraducaoClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8000/traducao?wsdl");
			
			QName qname = new QName("http://ws/","TraducaoService");
			
			Service service = Service.create(url, qname);
			
			ITraducao traducao = service.getPort(ITraducao.class);
		
			System.out.print(traducao.traduzir("oi"));
			
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
	};

}
