package com.whut.www.model;

import java.math.BigDecimal;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.id
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.lastName
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    private String lastname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.gender
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.email
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.salary
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    private BigDecimal salary;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.id
     *
     * @return the value of employee.id
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.id
     *
     * @param id the value for employee.id
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.lastName
     *
     * @return the value of employee.lastName
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.lastName
     *
     * @param lastname the value for employee.lastName
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.gender
     *
     * @return the value of employee.gender
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.gender
     *
     * @param gender the value for employee.gender
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.email
     *
     * @return the value of employee.email
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.email
     *
     * @param email the value for employee.email
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.salary
     *
     * @return the value of employee.salary
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.salary
     *
     * @param salary the value for employee.salary
     *
     * @mbg.generated Wed May 01 10:36:34 CST 2019
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}