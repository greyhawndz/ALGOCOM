package model;

public class Student {
	private String name;
	private int mathGrade;
	private int scienceGrade;
	private int englishGrade;
	private int filipinoGrade;
	private int socialStudiesGrade;
	private int algocomGrade;

	public Student() {}
	
	public Student(String name, int mathGrade, int scienceGrade, int englishGrade, int filipinoGrade,
			int socialStudiesGrade, int algocomGrade) {
		super();
		this.name = name;
		this.mathGrade = mathGrade;
		this.scienceGrade = scienceGrade;
		this.englishGrade = englishGrade;
		this.filipinoGrade = filipinoGrade;
		this.socialStudiesGrade = socialStudiesGrade;
		this.algocomGrade = algocomGrade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(int mathGrade) {
		this.mathGrade = mathGrade;
	}

	public int getScienceGrade() {
		return scienceGrade;
	}

	public void setScienceGrade(int scienceGrade) {
		this.scienceGrade = scienceGrade;
	}

	public int getEnglishGrade() {
		return englishGrade;
	}

	public void setEnglishGrade(int englishGrade) {
		this.englishGrade = englishGrade;
	}

	public int getFilipinoGrade() {
		return filipinoGrade;
	}

	public void setFilipinoGrade(int filipinoGrade) {
		this.filipinoGrade = filipinoGrade;
	}

	public int getSocialStudiesGrade() {
		return socialStudiesGrade;
	}

	public void setSocialStudiesGrade(int socialStudiesGrade) {
		this.socialStudiesGrade = socialStudiesGrade;
	}

	public int getAlgocomGrade() {
		return algocomGrade;
	}

	public void setAlgocomGrade(int algocomGrade) {
		this.algocomGrade = algocomGrade;
	}


	
	
}
