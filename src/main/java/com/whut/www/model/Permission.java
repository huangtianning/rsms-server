package com.whut.www.model;

import java.util.Date;

public class Permission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.operation
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    private String operation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.url
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.create_time
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.update_time
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.operation
     *
     * @return the value of permission.operation
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.operation
     *
     * @param operation the value for permission.operation
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.url
     *
     * @return the value of permission.url
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.url
     *
     * @param url the value for permission.url
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.create_time
     *
     * @return the value of permission.create_time
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.create_time
     *
     * @param createTime the value for permission.create_time
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.update_time
     *
     * @return the value of permission.update_time
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.update_time
     *
     * @param updateTime the value for permission.update_time
     *
     * @mbg.generated Wed May 08 22:55:29 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}