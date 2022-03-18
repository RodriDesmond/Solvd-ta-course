package hospital.models.enums;

public enum EDisease {

	INFLUENZA("Influenza", "Antiviral and pain relief medication, plenty of rest and plenty of liquids"),
	CHOLESTEROL("High cholesterol","Cholesterol medication, limit fat intake, exercise, no smoking. Weight loss if overweight"),
	ARRHYTHMIA("Heart arrhythmia","Arrhythmic medicine"),
	BLADDER_INFECTION("Bladder infection","Seven-day course of antibiotics, plenty of liquids"),
	OSTEOPOROSIS("Osteoporosis","Bone strength increasing medication, balanced diet with calcium and vitamin D"),
	HYPERTENSION("Hypertension","Beta blocker medication, low-sodium and low-fat diet, avoid alcohol"),
	CONJUNCTIVITIS("Conjunctivitis","Eye drops or artificial tears. Avoid close contact with other people"),
	GASTRITIS("Gastritis","Antacid medication, anti-inflammayory drugs. Avoid spicy food and alcohol");

	private final String name;
	private final String treatment;

	private EDisease(String name, String treatment){
		this.name = name;
		this.treatment = treatment;
	}

	public String getName() {
		return name;
	}

	public String getTreatment() {
		return treatment;
	}

	@Override
	public String toString() {
		return "\nDisease: " + name +
				"\nTreatment: " + treatment;
	}
}
