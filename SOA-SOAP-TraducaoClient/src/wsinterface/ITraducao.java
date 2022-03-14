package wsinterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ITraducao {

	@WebMethod
	public String traduzir(
		@WebParam(name= "Palavra")	String palavra);
}
