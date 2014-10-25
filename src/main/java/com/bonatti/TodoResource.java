package com.bonatti;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

	@PersistenceContext(unitName = "Admin")
	private EntityManager entityManager;
	
	@GET
	@Path("{id}")
	public Todo find(@PathParam("id") Long id) {
		return entityManager.find(Todo.class, id);
	}
	
	@GET
	public List<Todo> find() {
		return entityManager.createQuery("select t from Todo t order by t.id", Todo.class).getResultList();
	}
	
	@PUT
	public Todo save(Todo todo) {
		entityManager.persist(todo);
		return todo;
	}
	
	@POST
	public Todo switchStatus(Todo todo) {
		return entityManager.merge(todo);
	}
	
	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Long id) {
		Todo todo = entityManager.find(Todo.class, id);
		entityManager.remove(todo);
	}
}
