package br.com.mauriciotsilva.explorer.resource.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.mauriciotsilva.explorer.ExplorerException;

@Provider
public class ExplorerExceptionMapper implements ExceptionMapper<ExplorerException> {

	@Override
	public Response toResponse(ExplorerException exception) {
		return Response.status(exception.getCodigo()).entity(new RetornoErro(exception)).build();
	}

}
