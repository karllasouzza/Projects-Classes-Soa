package wsinterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ICalculo {
	
	@WebMethod
	public double adicionar(@WebParam(name="valor1") double valor1, 
			@WebParam(name="valor2") double valor2);
}
