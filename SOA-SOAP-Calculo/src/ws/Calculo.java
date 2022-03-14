package ws;

import javax.jws.WebService;

import wsinterface.ICalculo;

@WebService(endpointInterface="wsinterface.ICalculo")
public class Calculo implements ICalculo {

	@Override
	public double adicionar(double valor1, double valor2) {
		return valor1 + valor2;
	}

}
