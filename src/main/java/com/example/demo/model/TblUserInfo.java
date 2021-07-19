package com.example.demo.model;

import com.example.demo.aop.Dict;
import com.example.demo.aop.SensitiveLabel;
import com.example.demo.aop.SensitiveTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public class TblUserInfo {
    @ApiModelProperty(value = "主键")
    private String userId;

    @ApiModelProperty(value = "姓名",required = false)
    private String userName;

    @ApiModelProperty(value = "密码",required = false)
    private String password;

    @ApiModelProperty(value = "登录名",required = false)
    private String loginId;

    @SensitiveLabel(type = SensitiveTypeEnum.MOBILE_PHONE)
    @ApiModelProperty(value = "手机",required = false)
    private String telephone;

    @Dict(dictDataSource = "dataStatus")
    @ApiModelProperty(value = "1-有效 0-无效",required = false)
    private String dataStatus;

    /**
     * 主键
     * @return user_id 主键
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 主键
     * @param userId 主键
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 姓名
     * @return user_name 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 姓名
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 登录名
     * @return login_id 登录名
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * 登录名
     * @param loginId 登录名
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    /**
     * 手机
     * @return telephone 手机
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机
     * @param telephone 手机
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 1-有效 0-无效
     * @return data_status 1-有效 0-无效
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 1-有效 0-无效
     * @param dataStatus 1-有效 0-无效
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    /**
     *
     * @mbg.generated 2021-07-13
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TblUserInfo other = (TblUserInfo) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLoginId() == null ? other.getLoginId() == null : this.getLoginId().equals(other.getLoginId()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()));
    }

    /**
     *
     * @mbg.generated 2021-07-13
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLoginId() == null) ? 0 : getLoginId().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated 2021-07-13
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", loginId=").append(loginId);
        sb.append(", telephone=").append(telephone);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append("]");
        return sb.toString();
    }
}