package hospital.models.enums;

public enum ESpecialty {
	GEN_SUR ("General Surgery"),
	PAED ("Paediatrics"),
	CARD("Cardiology"),
	DERM("Dermatology");

	private final String specialtyName;

	ESpecialty(String specialty) { this.specialtyName = specialty;}

	public String getSpecialty() {
		return specialtyName;
	}

}
