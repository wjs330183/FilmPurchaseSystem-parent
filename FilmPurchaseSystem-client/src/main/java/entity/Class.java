package entity;

public class Class {
    /**
     * 等级ID
     */
    private String classId;
    /**
     *等级名称
     */
    private String className;
    /**
     * 等级折扣
     */
    private String classDiscount;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDiscount() {
        return classDiscount;
    }

    public void setClassDiscount(String classDiscount) {
        this.classDiscount = classDiscount;
    }
}
