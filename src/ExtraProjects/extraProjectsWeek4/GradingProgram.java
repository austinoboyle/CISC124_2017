package extraProjectsWeek4;

public class GradingProgram {
    public float quiz1Score = 0;
    public float quiz2Score = 0;
    public float quiz3Score = 0;
    public float midtermScore = 0;
    public float examScore = 0;
    public char letterGrade = 'F';
    public float numberGrade = 0;
    
    private float quizAverage(){
        return (this.quiz1Score + this.quiz2Score + this.quiz3Score) / 30;
    }
    
    private float midtermAverage(){
        return this.midtermScore/100;
    }
    
    private float finalExamAverage(){
        return this.examScore/100;
    }
    
    public void calculateNumericGrade(){
        this.numberGrade = this.quizAverage() * 25 +
                this.midtermAverage() * 35 +
                this.finalExamAverage() * 40;
        
    }
    
    public void calculateLetterGrade(){
        this.calculateNumericGrade();
        if (this.numberGrade >= 90)
            this.letterGrade = 'A';
        else if (this.numberGrade >= 80)
            this.letterGrade = 'B';
        else if (this.numberGrade >= 70)
            this.letterGrade = 'C';
        else if (this.numberGrade >= 60)
            this.letterGrade = 'D';
        else
            this.letterGrade = 'F';
    }
    
    public boolean equals(GradingProgram other){
        this.calculateLetterGrade();
        other.calculateNumericGrade();
        return (this.numberGrade == other.numberGrade);
    }
    
    public String toString(){
        String outputString = "";
        outputString += "Quiz 1 Score: " + Float.toString(this.quiz1Score) + "/10\n";
        outputString += "Quiz 2 Score: " + Float.toString(this.quiz2Score) + "/10\n";
        outputString += "Quiz 3 Score: " + Float.toString(this.quiz3Score) + "/10\n";
        outputString += "Midterm Score: " + Float.toString(this.midtermScore) + "/100\n";
        outputString += "Exam Score: " + Float.toString(this.examScore) + "/100\n";
        this.calculateLetterGrade();
        outputString += "Final Percentage Grade: " + Float.toString(this.numberGrade) + "\n";
        outputString += "Final Letter Grade: " + this.letterGrade;
        return outputString;
    }
    
    


    public static void main(String[] args){
        GradingProgram student1 = new GradingProgram();
        student1.quiz1Score = 9;
        student1.quiz2Score = 9;
        student1.quiz3Score = 9;
        
        student1.midtermScore = 90;
        student1.examScore = 16;
        student1.calculateLetterGrade();
        student1.calculateNumericGrade();
        System.out.println(student1.numberGrade);
        System.out.println(student1.letterGrade);
        System.out.println(student1);
    }
    
}
