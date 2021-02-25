/*
*
* TblInviteInfo.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-02-25
*/
package com.example.demo.model;

import java.util.Date;

public class TblInviteInfo {
    /**
     * 主键
     */
    private String id;

    /**
     * 邀约方
     */
    private String inviter;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 会议主题
     */
    private String meetingTheme;

    /**
     * 状态 0-无效 1-有效
     */
    private String dataStatus;

    /**
     * 会议状态 0-待确认 1-会议中 2-已完成 3-未参会
     */
    private String meetingStatus;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 会议内容
     */
    private String meetingContent;

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 邀约方
     * @return inviter 邀约方
     */
    public String getInviter() {
        return inviter;
    }

    /**
     * 邀约方
     * @param inviter 邀约方
     */
    public void setInviter(String inviter) {
        this.inviter = inviter == null ? null : inviter.trim();
    }

    /**
     * 开始时间
     * @return begin_time 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 开始时间
     * @param beginTime 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 会议主题
     * @return meeting_theme 会议主题
     */
    public String getMeetingTheme() {
        return meetingTheme;
    }

    /**
     * 会议主题
     * @param meetingTheme 会议主题
     */
    public void setMeetingTheme(String meetingTheme) {
        this.meetingTheme = meetingTheme == null ? null : meetingTheme.trim();
    }

    /**
     * 状态 0-无效 1-有效
     * @return data_status 状态 0-无效 1-有效
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 状态 0-无效 1-有效
     * @param dataStatus 状态 0-无效 1-有效
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    /**
     * 会议状态 0-待确认 1-会议中 2-已完成 3-未参会
     * @return meeting_status 会议状态 0-待确认 1-会议中 2-已完成 3-未参会
     */
    public String getMeetingStatus() {
        return meetingStatus;
    }

    /**
     * 会议状态 0-待确认 1-会议中 2-已完成 3-未参会
     * @param meetingStatus 会议状态 0-待确认 1-会议中 2-已完成 3-未参会
     */
    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus == null ? null : meetingStatus.trim();
    }

    /**
     * 
     * @return create_by 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 会议内容
     * @return meeting_content 会议内容
     */
    public String getMeetingContent() {
        return meetingContent;
    }

    /**
     * 会议内容
     * @param meetingContent 会议内容
     */
    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent == null ? null : meetingContent.trim();
    }

    /**
     *
     * @mbg.generated 2021-02-25
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
        TblInviteInfo other = (TblInviteInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInviter() == null ? other.getInviter() == null : this.getInviter().equals(other.getInviter()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getMeetingTheme() == null ? other.getMeetingTheme() == null : this.getMeetingTheme().equals(other.getMeetingTheme()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()))
            && (this.getMeetingStatus() == null ? other.getMeetingStatus() == null : this.getMeetingStatus().equals(other.getMeetingStatus()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getMeetingContent() == null ? other.getMeetingContent() == null : this.getMeetingContent().equals(other.getMeetingContent()));
    }

    /**
     *
     * @mbg.generated 2021-02-25
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInviter() == null) ? 0 : getInviter().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getMeetingTheme() == null) ? 0 : getMeetingTheme().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        result = prime * result + ((getMeetingStatus() == null) ? 0 : getMeetingStatus().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getMeetingContent() == null) ? 0 : getMeetingContent().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated 2021-02-25
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", inviter=").append(inviter);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", meetingTheme=").append(meetingTheme);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append(", meetingStatus=").append(meetingStatus);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", meetingContent=").append(meetingContent);
        sb.append("]");
        return sb.toString();
    }
}