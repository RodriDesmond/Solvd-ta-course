package hospital.exceptions;

public class HealthInsuranceCompanyException extends RuntimeException {

	public HealthInsuranceCompanyException() {}

	public HealthInsuranceCompanyException(String message) {
		super(message);
	}

	public HealthInsuranceCompanyException(String message, Throwable cause) { super(message, cause); }
}
