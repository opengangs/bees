package unsw.enrolment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enrolment {

    private CourseOffering offering;
    private Grade grade;
    private Student student;
    private List<Session> sessions;
    private ArrayList<Logger> loggers;
    private ArrayList<Assessment> assessments;

    public Enrolment(CourseOffering offering, Student student, Session... sessions) {
        this.offering = offering;
        this.student = student;
        this.grade = null; // Student has not completed course yet.
        student.addEnrolment(this);
        offering.addEnrolment(this);
        this.sessions = new ArrayList<>();
        for (Session session : sessions) {
            this.sessions.add(session);
        }

        loggers = new ArrayList<Logger>();
        assessments = new ArrayList<Assessment>();
    }

    public void addAssessment(Assessment a) throws IOException {
        assessments.add(a);
        for (Logger l : loggers) {
            l.update(this, a);
        }
    }

    public String getAssessmentName(Assessment a) {
        return a.getName();
    }

    public int getMark (Assessment a) {
        for (Assessment toFind : assessments) {
            if (toFind.equals (a)) {
                return toFind.getRawMark();
            }
        }

        return 0;
    }

    public Course getCourse() {
        return offering.getCourse();
    }

    public String getEnrolment() {
        return getCourse().getCourseCode();
    }

    public String getTerm() {
        return offering.getTerm();
    }

    public boolean hasPassed() {
        return grade != null && grade.isPassing();
    }

    public Grade getGrade() {
        return grade;
    }

    public String getStudent() {
        return student.getZID();
    }

    public void updateGrade(Grade newGrade) throws IOException {
        this.grade = newGrade;
    }

    public void addObserver (Logger newLogger) {
        loggers.add (newLogger);
    }

//    Whole course marks can no longer be assigned this way.
//    public void assignMark(int mark) {
//        grade = new Grade(mark);
//    }

}
