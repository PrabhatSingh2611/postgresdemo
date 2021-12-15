package University;

public class Subject {
    private Integer subjectId;
    private Integer subjectName;
    private Integer studentId;
    private Integer subjectMarks;

    public Subject(Integer subjectId, Integer subjectName, Integer studentId, Integer subjectMarks) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.studentId = studentId;
        this.subjectMarks = subjectMarks;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(Integer subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Integer subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName=" + subjectName +
                ", studentId=" + studentId +
                ", subjectMarks=" + subjectMarks +
                '}';
    }
}
