package btcChina.response;

public class ErrorResponse {
	JsonRpcError error;

	public JsonRpcError getError() {
		return error;
	}

	public void setError(JsonRpcError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorResponse [error=" + error + "]";
	}
}

class JsonRpcError {
	int code;
	String message;
	int id;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "JsonRpcError [code=" + code + ", message=" + message + ", id="
				+ id + "]";
	}
}
