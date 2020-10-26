package unsw.enrolment;
import java.util.ArrayList;

public class Mark implements Component {

    // Mark class stores all of the marks for grade and enrolment.
    private ArrayList<Component> allMarks = new ArrayList<Component>();

    public Mark() {
        super();
    }

    @Override
    public void add (Component child) {
        allMarks.add (child);
    }

    @Override
    public void remove (Component child) {
        allMarks.remove (child);
    }

    // Gets the 
    public int getAssessmentMark(Component assessment) {
        for (Component mark : allMarks) {
            if (mark.equals (assessment)) {
                return mark.getMark();
            }
        }

        return 0;
    }

    @Override
    public int getMark() {
        int finalMark = 0;
        for (Component mark : allMarks) {
            finalMark += mark.getMark();
        }

        return finalMark;
    }

    public int returnFinalMark() {
        return getMark() / allMarks.size();
    }
}