package EmployeeManagement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
  private String empNo;
  private String empNm;
  private boolean gender;
  private String address;
  private String email;
  private String phone;
  private float salary;
  private Date dateOfBirth;

  public Employee() {
  }

  public Employee(String empNo, String empNm, boolean gender, String address, String email, String phone, float salary,
      Date dateOfBirth) {
    this.empNo = empNo;
    this.empNm = empNm;
    this.gender = gender;
    this.address = address;
    this.email = email;
    this.phone = phone;
    this.salary = salary;
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmpNo() {
    return this.empNo;
  }

  public void setEmpNo(String empNo) {
    this.empNo = empNo;
  }

  public String getEmpNm() {
    return this.empNm;
  }

  public void setEmpNm(String empNm) {
    if (empNm.length() == 0) {
      throw new Error("Employee name is required!");
    }
    this.empNm = empNm;
  }

  public boolean isGender() {

    return this.gender;
  }

  public boolean getGender() {
    return this.gender;
  }

  public void setGender(boolean gender, String genderInput) {
    try {
      if (genderInput.equalsIgnoreCase("nam")) {
        gender = true;
      } else if (genderInput.equalsIgnoreCase("nu")) {
        gender = false;
      } else {
        throw new Error("Invalid gender!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    this.gender = gender;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    if (address.length() == 0) {
      throw new Error("Employee address is required!");
    }
    this.address = address;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    try {
      if (email.contains("@")) {
        String emailArr[] = email.split("@");
        if (emailArr.length != 2 || !emailArr[1].contains(".")) {
          throw new Error("Email is invalid");
        }
      } else {
        throw new Error("Email is invalid");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    try {
      if (phone.length() != 10) {
        System.out.printf("Your phone number input have %d digits", phone.length());
        throw new Error("Phone number must have 10 digits!");
      } else if (!phone.startsWith("0")) {
        throw new Error("Phone number must start with 0!");
      } else {
        Integer.parseInt(phone);
      }
    } catch (NumberFormatException e) {
      throw new NumberFormatException(phone + " is an invalid phone number!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    this.phone = phone;
  }

  public float getSalary() {
    return this.salary;
  }

  public void setSalary(float salary, String salaryInput) {
    try {
      if (salaryInput.startsWith("-")) {
        throw new Error("Salary must greater than 0!");
      } else {
        salary = Float.parseFloat(salaryInput);
      }
    } catch (NumberFormatException e) {
      throw new NumberFormatException("Invalid salary!");
    }
    this.salary = salary;
  }

  public Date getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth, String dateOfBirthInput) {
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String dateValidationArr[] = dateOfBirthInput.split("/");
      if (Integer.parseInt(dateValidationArr[0]) < 0 ||
          Integer.parseInt(dateValidationArr[0]) > 31 ||
          Integer.parseInt(dateValidationArr[1]) < 0 ||
          Integer.parseInt(dateValidationArr[1]) > 12 ||
          Integer.parseInt(dateValidationArr[2]) < 1900 ||
          Integer.parseInt(dateValidationArr[2]) > 2022) {
        throw new Error("Invalid date!");
      } else {
        dateOfBirth = formatter.parse(dateOfBirthInput);
      }

    } catch (Exception e) {
      throw new Error("Invalid date format!");
    }
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return "{" +
        " empNo='" + getEmpNo() + "'" +
        ", empNm='" + getEmpNm() + "'" +
        ", gender='" + isGender() + "'" +
        ", address='" + getAddress() + "'" +
        ", email='" + getEmail() + "'" +
        ", phone='" + getPhone() + "'" +
        ", salary='" + getSalary() + "'" +
        ", dateOfBirth='" + getDateOfBirth() + "'" +
        "}";
  }

}
