package com.whut.www.model;

import java.util.Date;

public class RolePermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.id
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.rid
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.pid
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    private Integer pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.create_time
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.update_time
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.id
     *
     * @return the value of role_permission.id
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.id
     *
     * @param id the value for role_permission.id
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.rid
     *
     * @return the value of role_permission.rid
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.rid
     *
     * @param rid the value for role_permission.rid
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.pid
     *
     * @return the value of role_permission.pid
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.pid
     *
     * @param pid the value for role_permission.pid
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.create_time
     *
     * @return the value of role_permission.create_time
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.create_time
     *
     * @param createTime the value for role_permission.create_time
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.update_time
     *
     * @return the value of role_permission.update_time
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.update_time
     *
     * @param updateTime the value for role_permission.update_time
     *
     * @mbg.generated Thu May 09 11:42:47 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}