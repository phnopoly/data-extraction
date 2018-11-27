import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Task:
// xls -> String
// String -> textfile
public class Driver {

    private static final String XLSFILENAME = "car_accident_data";
    private static final String TXTFILENAME = "extractedData";
    private static Spreadsheet ss;

    public static void main(String[] args) {
        ss = new Spreadsheet(XLSFILENAME);
        try {
            loadTextfile(ss.iterateTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(ss.toString());
        // execute once - comment when database is loaded
        // loadDatabase();
    }

    private static void loadTextfile(String contents) throws IOException {
        BufferedWriter writer =
                new BufferedWriter(new FileWriter(TXTFILENAME + ".txt"));
        writer.write(contents);
        writer.close();
    }

}
