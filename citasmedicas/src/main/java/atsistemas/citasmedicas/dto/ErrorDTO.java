package atsistemas.citasmedicas.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {
	

	private static final long serialVersionUID = 3570776959639217761L;

	private Integer code;
	
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
