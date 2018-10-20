public class Entity {
    private int id;
    private double score;
    private char grade;
    private String askQuestions;
    private String textingInClass;
    private String lateInClass;

    public Entity(int id, double score, char grade, String askQuestions, String textingInClass, String lateInClass) {
        this.id = id;
        this.score = score;
        this.grade = grade;
        this.askQuestions = askQuestions;
        this.textingInClass = textingInClass;
        this.lateInClass = lateInClass;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%10d %10.2f %10c ", id, score, grade));
        stringBuilder.append(String.format("%10s ", askQuestions));
        stringBuilder.append(String.format("%10s ", textingInClass));
        stringBuilder.append(String.format("%10s\n", lateInClass));
        return stringBuilder.toString();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getAskQuestions() {
        return askQuestions;
    }

    public void setAskQuestions(String askQuestions) {
        this.askQuestions = askQuestions;
    }

    public String getTextingInClass() {
        return textingInClass;
    }

    public void setTextingInClass(String textingInClass) {
        this.textingInClass = textingInClass;
    }

    public String getLateInClass() {
        return lateInClass;
    }

    public void setLateInClass(String lateInClass) {
        this.lateInClass = lateInClass;
    }
}
