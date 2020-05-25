package com.test.model;

import java.util.Objects;

public class Department {
    private int departmentId;
    private String departmentName;
    private int departmentBudget;

    public Department() {
    }

    public Department(int departmentId, String departmentName, int departmentBudget) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentBudget = departmentBudget;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentBudget() {
        return departmentBudget;
    }

    public void setDepartmentBudget(int departmentBudget) {
        this.departmentBudget = departmentBudget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getDepartmentId() == that.getDepartmentId() &&
                getDepartmentBudget() == that.getDepartmentBudget() &&
                Objects.equals(getDepartmentName(), that.getDepartmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentId(), getDepartmentName(), getDepartmentBudget());
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentBudget=" + departmentBudget +
                '}';
    }
}
