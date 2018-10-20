import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Task:
// xls -> java
// java -> database
// database - > textfile
public class Driver {

    private static final String XLSFILENAME = "moody_training_data";
    private static final String TXTFILENAME = "raw_data";
    private static Spreadsheet ss;
    private static DatabaseUploader dbu;

    public static void main(String[] args) {
        ss = new Spreadsheet(XLSFILENAME);
        ss.iterateList();
        dbu = new DatabaseUploader();

        // execute once - comment when database is loaded
        /* loadDatabase();
        try {
            dbu.getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        // may execute multiple times

    }

    private static void loadDatabase(){
        for (int i = 0; i < ss.getEntities().size(); i++) {
            Entity e = ss.getEntities().get(i);
            System.out.println(e);
            try {
                dbu.executeCommand(
                        e.getId(), e.getScore(),
                        (new Character(e.getGrade())).toString(),
                        e.getAskQuestions(), e.getTextingInClass(), e.getLateInClass());
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }

    private static void loadTextfile(){

    }


}
