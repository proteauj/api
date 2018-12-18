package com.versatile.api.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class EmployeeRoleId implements Serializable {
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_user")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_role")
    private UserRole role;

    public EmployeeRoleId() {
    }

    public EmployeeRoleId(Employee employee, UserRole role) {
        this.employee = employee;
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeRoleId{" +
                "employee=" + employee +
                ", role=" + role +
                '}';
    }
}
