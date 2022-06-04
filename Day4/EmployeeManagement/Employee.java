package EmployeeManagement;

import java.util.Date;

public class Employee {
  private String empID;
  private String empName;
  private int empBirthYear;
  private String gender;
  private Date startDate;
  private float coeff;
  private float salary;

  public Employee() {
  }

  public Employee(String empID, String empName, int empBirthYear, String gender, Date startDate, float coeff,
      float salary) {
    this.empID = empID;
    this.empName = empName;
    this.empBirthYear = empBirthYear;
    this.gender = gender;
    this.startDate = startDate;
    this.coeff = coeff;
    this.salary = salary;
  }

  public String getEmpID() {
    return this.empID;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getEmpName() {
    return this.empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public int getEmpBirthYear() {
    return this.empBirthYear;
  }

  public void setEmpBirthYear(int empBirthYear) {
    this.empBirthYear = empBirthYear;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public float getCoeff() {
    return this.coeff;
  }

  public void setCoeff(float coeff) {
    this.coeff = coeff;
  }

  public float getSalary() {
    return this.salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "{" +
        " empID='" + getEmpID() + "'" +
        ", empName='" + getEmpName() + "'" +
        ", empBirthYear='" + getEmpBirthYear() + "'" +
        ", gender='" + getGender() + "'" +
        ", startDate='" + getStartDate() + "'" +
        ", coeff='" + getCoeff() + "'" +
        ", salary='" + getSalary() + "'" +
        "}";
  }

}
