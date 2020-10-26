package unsw.enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Logger {

    File newFile;

    public Logger() {
    }

    public void update(Enrolment e, Assessment a) throws IOException {
        newFile = new File(e.getCourse().getCourseCode() + "-" + e.getTerm() + "-" + e.getStudent());
        if (newFile.createNewFile()) {
            // just create the new file.
        } else {

        }

        writeFile(newFile, "Date: " + LocalDate.now() + "\t\t" + "Time: " + LocalDateTime.now() + "\t\t" + "Assessment: " + e.getAssessmentName(a) + "\t\t" + "Mark: " + e.getMark(a) + "\n");
    }

    private void writeFile(File f, String stuff) throws IOException {
        FileWriter newWriter = new FileWriter (f, true);
        newWriter.write (stuff);
        newWriter.close();
    }
}