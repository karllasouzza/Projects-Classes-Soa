package ws;

import javax.jws.WebService;

import wsinterface.ITraducao;

@WebService(endpointInterface="wsinterface.ITraducao")
public class Traducao implements ITraducao {

	@Override
	public String traduzir(String palavra) {
		if(palavra.equalsIgnoreCase("oi")) {
			
		return "hello";
		} else if (palavra.equalsIgnoreCase("amor")) {
			return "love";
		}
		else if (palavra.equalsIgnoreCase("te amo")) {
			return "love your";
		}
		else if (palavra.equalsIgnoreCase("sempre")) {
			return "forever";
		}
		else if (palavra.equalsIgnoreCase("eu e voce")) {
			return "iam and your";
		}
		else if (palavra.equalsIgnoreCase("gato")) {
			return "cat";
		}
		else if (palavra.equalsIgnoreCase("cachorro")) {
			return "dog";
		}
		else {
			return "Palavra não identificada!";
		}
	}
}
