package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class EmployeeRole {

    @EmbeddedId
    private EmployeeRoleId employeeRoleId;

    public EmployeeRole() {
    }

    public EmployeeRole(EmployeeRoleId employeeRoleId) {
        this.employeeRoleId = employeeRoleId;
    }

    public EmployeeRoleId getEmployeeRoleId() {
        return employeeRoleId;
    }

    public void setEmployeeRoleId(EmployeeRoleId employeeRoleId) {
        this.employeeRoleId = employeeRoleId;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "employeeRoleId=" + employeeRoleId +
                '}';
    }
}
