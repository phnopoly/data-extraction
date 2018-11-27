import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {

    private FileInputStream file;
    private HSSFWorkbook workbook;
    private HSSFSheet table;
    private final int NUMROWS = 65536;

    public Spreadsheet(String fileName) {
        try {
            this.file = new FileInputStream(fileName + ".xls");
            this.workbook = new HSSFWorkbook(file);
            this.table = workbook.getSheet(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String iterateTable() {
        StringBuilder sB = new StringBuilder();
        for (int i = 1; i < NUMROWS; i++) {
            // System.out.println(getStringContents(i));
            sB.append(getStringContents(i));
            sB.append("\n");
        }
        return sB.toString();
    }

    private String getStringContents(int index) {
        StringBuilder sB = new StringBuilder();
        sB.append(table.getRow(index).getCell(0).toString()); //accidentIndex
        sB.append(" ");
        sB.append((int)Double.parseDouble(table.getRow(index).getCell(14).toString())); //sexOfDriver
        sB.append(" ");
        sB.append((int)Double.parseDouble(table.getRow(index).getCell(49).toString())); //weatherConditions
        sB.append(" ");
        sB.append((int)Double.parseDouble(table.getRow(index).getCell(50).toString())); //roadSurface
        sB.append(" ");
        sB.append((int)Double.parseDouble(table.getRow(index).getCell(41).toString())); //speedLimit
        sB.append(" ");
        sB.append((int)Double.parseDouble(table.getRow(index).getCell(30).toString())); //accidentSeverity,
        sB.append(" ");
        sB.append((int)Double.parseDouble(table.getRow(index).getCell(31).toString())); //numberOfVehicles
        sB.append(" ");
        sB.append(table.getRow(index).getCell(54).toString().equals("2.0")? "0": "1");
        //policeInvolvement 0 - no. 1 - yes
        return sB.toString();
    }

    @Override
    // accidentIndex, sexOfDriver, weatherCond., roadSurface,
    // speedLimit, severity, numVehicles, policeInvolve.
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%15s %15s %15s %15s %15s %15s %15s %15s\n" +
                        "----------------------------------------------------------------------\n",
                "accidentIndex", "sexOfDriver", "weatherCond.", "roadSurface",
                "speedLimit", "severity", "numVehicles","policeInvolve."));
        for (int i = 1; i < NUMROWS - 1; i++) {
            stringBuilder.append(getStringContents(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public FileInputStream getFile() { return file; }

    public void setFile(FileInputStream file) { this.file = file; }

    public HSSFWorkbook getWorkbook() { return workbook; }

    public void setWorkbook(HSSFWorkbook workbook) { this.workbook = workbook; }

    public HSSFSheet getTable() { return table; }

    public void setTable(HSSFSheet table) { this.table = table; }

    public int getNUMROWS() { return NUMROWS; }
}