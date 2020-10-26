package unsw.enrolment.test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;

import unsw.enrolment.Course;
import unsw.enrolment.CourseOffering;
import unsw.enrolment.Enrolment;
import unsw.enrolment.Lecture;
import unsw.enrolment.Student;
import unsw.enrolment.Tutorial;
import unsw.enrolment.*;

public class EnrolmentTest {

    public static void main(String[] args) throws IOException {

        // Create courses
        Course comp1511 = new Course("COMP1511", "Programming Fundamentals");
        Course comp1531 = new Course("COMP1531", "Software Engineering Fundamentals");
        comp1531.addPrereq(comp1511);
        Course comp2521 = new Course("COMP2521", "Data Structures and Algorithms");
        comp2521.addPrereq(comp1511);

        CourseOffering comp1511Offering = new CourseOffering(comp1511, "19T1");
        CourseOffering comp1531Offering = new CourseOffering(comp1531, "19T1");
        CourseOffering comp2521Offering = new CourseOffering(comp2521, "19T2");


        // Create some sessions for the courses
        Lecture lecture1511 = new Lecture(comp1511Offering, "Rex Vowels", DayOfWeek.TUESDAY, LocalTime.of(12, 0),LocalTime.of(14, 0), "Andrew Taylor");
        Lecture lecture1531 = new Lecture(comp1531Offering, "CLB 5", DayOfWeek.MONDAY, LocalTime.of(9, 0),LocalTime.of(11, 0), "Aarthi Natarajan");
        Lecture lecture2521 = new Lecture(comp2521Offering, "Clancy Auditorium", DayOfWeek.FRIDAY, LocalTime.of(15, 0),LocalTime.of(17, 0), "Ashesh Mahidadia");

        Tutorial tute1531 = new Tutorial(comp1531Offering, "Quad 1041", DayOfWeek.WEDNESDAY, LocalTime.of(18, 0), LocalTime.of(19,0), "Hugh Chan");

        // Create a student
        Student student = new Student("z5555555");

        // Enrol the student in COMP1511 for T1 (this should succeed)
        Enrolment comp1511Enrolment = comp1511Offering.enrol(student, lecture1511);

        Logger logger = new Logger();
        comp1511Enrolment.addObserver(logger);

        if (comp1511Enrolment != null)
            System.out.println("Enrolled in COMP1511");

        // Enrol the student in COMP1531 for T1 (this should fail as they
        // have not met the prereq)
        Enrolment comp1531Enrolment = comp1531Offering.enrol(student, lecture1531, tute1531);

        if (comp1531Enrolment == null)
            System.out.println("Can't enrol in COMP1531");

        // Give the student a passing grade for COMP1511
//        comp1511Enrolment.assignMark(65);

        // Assign marks for comp1511
        // TODO Give the student a passing mark for assignment 1

        // NEW MARK.
        Mark comp1511Mark = new Mark();
        Grade comp1511Grade = new Grade(comp1511Mark);

        // New Assessment and input the mark for the assessment.
        Assessment comp1511Assessment1 = new Assessment("Assessment 1");
        comp1511Assessment1.addNewAssessment("Assessment 1", 90);
        // Add to the comp1511Mark.
        comp1511Mark.add(comp1511Assessment1);
        // Add to enrolment.
        comp1511Enrolment.addAssessment(comp1511Assessment1);
        System.out.println (comp1511Mark.getMark());

        // TODO Give the student a passing mark for milestone 1 of assignment 2
        // New Assessment that is composed of two assessment tasks.
        Assessment comp1511Assessment2 = new Assessment("Assessment 2");

        // Milestone 1 with a score of 80.
        comp1511Assessment2.addNewAssessment("Milestone 1", 80);
        // Milestone 2 with a score of 100.
        comp1511Assessment2.addNewAssessment("Milestone 2", 70);

        // Updates comp1511Mark with new marks.
        comp1511Mark.add(comp1511Assessment2);
        comp1511Enrolment.addAssessment(comp1511Assessment2);

        // Gets the assessment mark for assessment 1.
        System.out.println ("Assessment 1: " + comp1511Mark.getAssessmentMark(comp1511Assessment1));
        // Gets the assessment mark for assessment 2.
        System.out.println ("Assessment 2: " + comp1511Mark.getAssessmentMark(comp1511Assessment2));
        // Gets the raw mark.
        System.out.println ("Raw total mark: " + comp1511Mark.getMark());
        // Finally returns the final mark of the course.
        System.out.println ("Final mark: " + comp1511Mark.returnFinalMark());

        // update grade.
        comp1511Grade.updateGrade(comp1511Mark);
        comp1511Enrolment.updateGrade(comp1511Grade);
        System.out.println ("Grade: " + comp1511Grade.getGrade());

        Enrolment comp2521Enrolment = comp2521Offering.enrol(student, lecture2521);

        if (comp2521Enrolment != null)
            System.out.println("Enrolled in COMP2521");
    }
}
