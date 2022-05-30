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

import dao.NotesDAO;
import model.Notes;

@Path("/wsnotes")
public class WSNotes {

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String Insert(Notes note) {
		NotesDAO dao = new NotesDAO();
		return dao.InsertNote(note);
	}
	
	@GET
	@Path("/list")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Notes> ListAll() {
		NotesDAO dao = new NotesDAO();
		return dao.ListALL();
	}
	
	@GET
	@Path("/getbyid/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Notes getByID(@PathParam("id") int id) {
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
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String UpdateByID(Notes produto) {
		NotesDAO dao = new NotesDAO();
		return dao.UpdateNoteByID(produto);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteByID(@PathParam("id") int id) {
		NotesDAO dao = new NotesDAO();
		return dao.DeletNoteByID(id);
	}
}
