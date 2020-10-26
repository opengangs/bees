package unsw.enrolment;

public class Grade {
    
    private Mark mark;
    private String grade;

    public Grade(Mark mark) {
        this.mark = mark;
        this.grade = null;
    }

    public boolean isPassing() {
        return mark.returnFinalMark() >= 50;
    }

    public int getMarks(Assessment assessment) {
        return mark.getAssessmentMark(assessment);
    }

    public String getGrade() {
        return grade;
    }
    public void updateGrade(Mark mark) {
        if (mark.returnFinalMark() < 50)
            grade = "FL";
        else if (mark.returnFinalMark() < 65)
            grade = "PS";
        else if (mark.returnFinalMark() < 75)
            grade = "CR";
        else if (mark.returnFinalMark() < 85)
            grade = "DN";
        else
            grade = "HD";
    }
}
