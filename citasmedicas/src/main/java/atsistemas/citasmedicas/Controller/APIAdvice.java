package atsistemas.citasmedicas.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.citasmedicas.dto.ErrorDTO;
import atsistemas.citasmedicas.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@ResponseBody
@ControllerAdvice(/*annotations = RestController,*/ basePackages = "atsistemas.citasmedicas.Controller")
public class APIAdvice {

/*	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO notFound(NotFoundException e) {
	return new ErrorDTO(e.getCode(), e.getMessage());

*/
	
}
