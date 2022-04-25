package wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProdutoDAO;
import model.Produto;

@Path("/wsproduto")
public class WSProduto {
	
	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String salvar(Produto produto) {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.salvar(produto);
	};
}
