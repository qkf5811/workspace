package qkf.sto.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ExpressQuery {

	@WebMethod
	public String queryJsonByCode(String code);
}
