package hospital.models;

public enum Specialty {
	GEN_SUR ("General Surgery"),
	PAED ("Paediatrics"),
	CARD("Cardiology"),
	DERM("Dermatology");

	private final String specialtyName;

	Specialty(String specialty) { this.specialtyName = specialty;}

	public String getSpecialty() {
		return specialtyName;
	}

}
