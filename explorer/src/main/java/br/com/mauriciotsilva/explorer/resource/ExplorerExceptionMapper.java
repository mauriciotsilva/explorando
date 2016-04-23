package br.com.mauriciotsilva.explorer.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.mauriciotsilva.explorer.ExplorerException;
import br.com.mauriciotsilva.explorer.resource.error.RetornoErro;

@Provider
public class ExplorerExceptionMapper implements ExceptionMapper<ExplorerException> {

	@Override
	public Response toResponse(ExplorerException exception) {
		exception.printStackTrace();
		return Response.status(exception.getCodigo()).entity(new RetornoErro(exception)).build();
	}

}
