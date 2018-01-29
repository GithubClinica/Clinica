package atsistemas.citasmedicas.exceptions;

public class NotFoundException extends Exception {

	
		private static final long serialVersionUID = -7406696324422023919L;

		private static final String MSG = "La entidad buscada no existe";

		public NotFoundException(String message) {
			super(message);
		}

		public NotFoundException() {
			super(MSG);
		}

}
