package qkf.sto.service.impl;

import javax.jws.WebService;

import qkf.sto.service.ExpressQuery;
import qkf.sys.common.ExPool;
import qkf.sys.common.ExQuery;

@WebService
public class ExpressQueryImpl implements ExpressQuery {


	
	@Override
	public String queryJsonByCode(String code) {

		ExQuery query = ExPool.getQuery(code);
		if (query == null) {
			query = ExPool.pool(code);
		}
		
		return query.query();
	}

}
