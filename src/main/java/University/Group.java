package University;

public class Group {
    private Integer groupId;
    private Integer DeptId;

    public Group() {

    }

    public Group(Integer groupId, Integer deptId) {
        this.groupId = groupId;
        DeptId = deptId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getDeptId() {
        return DeptId;
    }

    public void setDeptId(Integer deptId) {
        DeptId = deptId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", DeptId=" + DeptId +
                '}';
    }
}
