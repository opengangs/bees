package unsw.enrolment;

import java.util.ArrayList;

// An assessment contains a mark or marks.
public class Assessment implements Component {

    private ArrayList<Integer> marks;
    private String name;
    private ArrayList<String> assessments;

    public Assessment(String assessmentName) {
        super();
        this.name = assessmentName;
        this.marks = new ArrayList<Integer>();
        this.assessments = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(Component child) {
        return;
    }

    @Override
    public void remove(Component child) {
        return;
    }

    @Override
    public int getMark() {
        int totalMark = 0;
        int finalMark;
        for (int m : marks) {
            totalMark += m;
        }

        finalMark = totalMark / marks.size();
        return finalMark;
    }

    public int getRawMark() {
        int totalMark = 0;
        for (int m : marks) {
            totalMark += m;
        }

        return totalMark;
    }

    public void addNewAssessment(String ass, int mark) {
        assessments.add(ass);
        marks.add(mark);
    }
}