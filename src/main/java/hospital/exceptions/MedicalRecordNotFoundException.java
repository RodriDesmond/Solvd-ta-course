package hospital.exceptions;

public class MedicalRecordNotFoundException extends RuntimeException{

    public MedicalRecordNotFoundException() {
    }

    public MedicalRecordNotFoundException(String message) {
        super(message);
    }

    public MedicalRecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
