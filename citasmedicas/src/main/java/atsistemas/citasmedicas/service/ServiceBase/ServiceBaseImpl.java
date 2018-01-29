package atsistemas.citasmedicas.service.ServiceBase;

import org.springframework.util.StringUtils;

public abstract class ServiceBaseImpl {
	
	protected String buildQueryTextParam(String text) {
		if (StringUtils.isEmpty(text)) {
			text = "%";
		} else {
			text = "%" + text.toUpperCase() + "%";
		}
		return text;
	}

}
