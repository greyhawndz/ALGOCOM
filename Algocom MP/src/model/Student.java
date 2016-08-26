package model;

public class Student {
	private String name;
	private float mathGrade;
	private float scienceGrade;
	private float englishGrade;
	private float filipinoGrade;
	private float socialStudiesGrade;
	private float algocomGrade;
        private float average;
        private int assignId;

	public Student() {}
	
	public Student(String name, float mathGrade, float scienceGrade, float englishGrade, float filipinoGrade,
			float socialStudiesGrade, float algocomGrade) {
		super();
		this.name = name;
		this.mathGrade = mathGrade;
		this.scienceGrade = scienceGrade;
		this.englishGrade = englishGrade;
		this.filipinoGrade = filipinoGrade;
		this.socialStudiesGrade = socialStudiesGrade;
		this.algocomGrade = algocomGrade;
                this.average = (mathGrade + scienceGrade + englishGrade + filipinoGrade + socialStudiesGrade + algocomGrade)/6;
	}

        public int getAssignId() {
            return assignId;
        }

        public void setAssignId(int assignId) {
            this.assignId = assignId;
        }
        
        
        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }
        
        

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(int mathGrade) {
		this.mathGrade = mathGrade;
	}

	public float getScienceGrade() {
		return scienceGrade;
	}

	public void setScienceGrade(int scienceGrade) {
		this.scienceGrade = scienceGrade;
	}

	public float getEnglishGrade() {
		return englishGrade;
	}

	public void setEnglishGrade(int englishGrade) {
		this.englishGrade = englishGrade;
	}

	public float getFilipinoGrade() {
		return filipinoGrade;
	}

	public void setFilipinoGrade(int filipinoGrade) {
		this.filipinoGrade = filipinoGrade;
	}

	public float getSocialStudiesGrade() {
		return socialStudiesGrade;
	}

	public void setSocialStudiesGrade(int socialStudiesGrade) {
		this.socialStudiesGrade = socialStudiesGrade;
	}

	public float getAlgocomGrade() {
		return algocomGrade;
	}

	public void setAlgocomGrade(int algocomGrade) {
		this.algocomGrade = algocomGrade;
	}


	
	
}
