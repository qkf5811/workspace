package qkf.sto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qkf.sto.service.impl.ExpressQuery;

@Controller
@RequestMapping("/sto")
public class StoController {
 
	@Autowired
	private ExpressQuery exQuery;
	
	@ResponseBody
	@RequestMapping("/queryExpress")
	public String stoQueryByCode(String code) {
		
		String json = exQuery.queryJsonByCode(code);
		return json;
	}
}
