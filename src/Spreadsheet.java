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
    private final int NUMROWS = 999;
    private List<Entity> entities;

    public Spreadsheet(String fileName) {
        try {
            this.file = new FileInputStream(fileName + ".xls");
            this.workbook = new HSSFWorkbook(file);
            this.table = workbook.getSheet(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        entities = new ArrayList<>();
    }

    public void iterateList() {
        for (int i = 1; i < NUMROWS; i++) {
            entities.add(createEntity(i));
        }
    }

    private Entity createEntity(int index) {
        return new Entity(
                (int) Double.parseDouble(table.getRow(index).getCell(0).toString()), //id
                Double.parseDouble(table.getRow(index).getCell(1).toString()), //score
                table.getRow(index).getCell(2).toString().charAt(0), //grade
                table.getRow(index).getCell(3).toString(), //askQuestions
                table.getRow(index).getCell(4).toString(), //textingInClass
                table.getRow(index).getCell(5).toString()  //LateInClass
        );
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%10s %10s %10s %10s %10s %10s\n" +
                        "----------------------------------------------------------------------\n",
                "ID", "Score", "Grade", "questions", "texting", "late"));
        for (int i = 0; i < NUMROWS - 1; i++) {
            stringBuilder.append(entities.get(i));
        }
        return stringBuilder.toString();
    }

    public FileInputStream getFile() { return file; }

    public void setFile(FileInputStream file) { this.file = file; }

    public HSSFWorkbook getWorkbook() { return workbook; }

    public void setWorkbook(HSSFWorkbook workbook) { this.workbook = workbook; }

    public HSSFSheet getTable() { return table; }

    public void setTable(HSSFSheet table) { this.table = table; }

    public List<Entity> getEntities() { return entities; }

    public void setEntities(List<Entity> entities) { this.entities = entities; }

    public int getNUMROWS() { return NUMROWS; }
}
