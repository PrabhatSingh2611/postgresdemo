package University;

public class Department {
    private Integer DeptId;
    private String DeptName;

    public Department() {
    }

    public Department(Integer deptId, String deptName) {
        DeptId = deptId;
        DeptName = deptName;
    }

    public Integer getDeptId() {
        return DeptId;
    }

    public void setDeptId(Integer deptId) {
        DeptId = deptId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
}
