import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    private static final String FILENAME = "moody_training_data";

    public static void main(String[] args) {
        Spreadsheet ss = null;
        ss = new Spreadsheet(FILENAME);
        ss.iterateList();
        System.out.println(ss.toString());
    }

    private static void initFields() {
    }

}
