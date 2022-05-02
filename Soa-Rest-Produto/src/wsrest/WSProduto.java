package wsrest;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
	
	@GET
	@Path("/listartodos")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listarTodos() {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.listarTodos();
	}
}