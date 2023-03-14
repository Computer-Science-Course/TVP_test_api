package uea.api_test.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private List<String> errors;
	private String message;
	private String path;
	
	public StandardError() {
	}
	
	public StandardError(Instant timestamp, Integer status, List<String> erros, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errors = erros;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getErros() {
		return errors;
	}

	public void setErrors(List<String> erros) {
		this.errors = erros;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
