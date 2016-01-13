package io.RSS.exception;

public class NotFoundException extends Exception {

		
		/**
	 * 
	 */
	private static final long serialVersionUID = -7130856344502504679L;

		public NotFoundException(String msg)
		{
			super(msg);
		}
		
		public NotFoundException (String msg, Throwable cause){
			super(msg, cause);
		}
}
