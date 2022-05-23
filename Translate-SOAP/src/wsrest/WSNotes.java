package wsrest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.ResponseBuilder;

import dao.NotesDAO;
import model.Notes;

@Path("/wsproduto")
public class WSNotes {

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String salvar(Notes note) {
		NotesDAO dao = new NotesDAO();
		return dao.InsertNote(note);
	}
	
	@GET
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Notes> listarTodos() {
		NotesDAO dao = new NotesDAO();
		return dao.ListALL();
	}
	
	@GET
	@Path("/getbyid/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Notes getPorCodigo(@PathParam("id") int id) {
		NotesDAO dao = new NotesDAO();
		return dao.GetNoteByID(id);
	}
	
	@GET
	@Path("/search/{searchContent}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Notes> getPorDescricao(@PathParam("descricao") String searchContent) {
		NotesDAO dao = new NotesDAO();
		return dao.GetNoteBySearch(searchContent);
	}
	
	@PUT
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String alterar(Notes produto) {
		NotesDAO dao = new NotesDAO();
		return dao.alterar(produto);
	}
	
	@DELETE
	@Path("/excluir/{codigo}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String excluir(@PathParam("codigo") int codigo) {
		NotesDAO dao = new NotesDAO();
		return dao.excluir(codigo);
	}
}
