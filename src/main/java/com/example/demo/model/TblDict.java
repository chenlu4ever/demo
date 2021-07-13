package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public class TblDict extends TblDictKey {
    @ApiModelProperty(value = "字典名称",required = true)
    private String dictName;

    @ApiModelProperty(value = "数据字典翻译",required = true)
    private String dictItemName;

    @ApiModelProperty(value = "排序",required = false)
    private Integer dictSrot;

    @ApiModelProperty(value = "1-有效 0-无效",required = false)
    private String dictStatus;

    /**
     * 字典名称
     * @return dict_name 字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 字典名称
     * @param dictName 字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    /**
     * 数据字典翻译
     * @return dict_item_name 数据字典翻译
     */
    public String getDictItemName() {
        return dictItemName;
    }

    /**
     * 数据字典翻译
     * @param dictItemName 数据字典翻译
     */
    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName == null ? null : dictItemName.trim();
    }

    /**
     * 排序
     * @return dict_srot 排序
     */
    public Integer getDictSrot() {
        return dictSrot;
    }

    /**
     * 排序
     * @param dictSrot 排序
     */
    public void setDictSrot(Integer dictSrot) {
        this.dictSrot = dictSrot;
    }

    /**
     * 1-有效 0-无效
     * @return dict_status 1-有效 0-无效
     */
    public String getDictStatus() {
        return dictStatus;
    }

    /**
     * 1-有效 0-无效
     * @param dictStatus 1-有效 0-无效
     */
    public void setDictStatus(String dictStatus) {
        this.dictStatus = dictStatus == null ? null : dictStatus.trim();
    }

    /**
     *
     * @mbg.generated 2021-03-04
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
        TblDict other = (TblDict) that;
        return (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictItemNo() == null ? other.getDictItemNo() == null : this.getDictItemNo().equals(other.getDictItemNo()))
            && (this.getDictName() == null ? other.getDictName() == null : this.getDictName().equals(other.getDictName()))
            && (this.getDictItemName() == null ? other.getDictItemName() == null : this.getDictItemName().equals(other.getDictItemName()))
            && (this.getDictSrot() == null ? other.getDictSrot() == null : this.getDictSrot().equals(other.getDictSrot()))
            && (this.getDictStatus() == null ? other.getDictStatus() == null : this.getDictStatus().equals(other.getDictStatus()));
    }

    /**
     *
     * @mbg.generated 2021-03-04
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictCode() == null) ? 0 : getDictCode().hashCode());
        result = prime * result + ((getDictItemNo() == null) ? 0 : getDictItemNo().hashCode());
        result = prime * result + ((getDictName() == null) ? 0 : getDictName().hashCode());
        result = prime * result + ((getDictItemName() == null) ? 0 : getDictItemName().hashCode());
        result = prime * result + ((getDictSrot() == null) ? 0 : getDictSrot().hashCode());
        result = prime * result + ((getDictStatus() == null) ? 0 : getDictStatus().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated 2021-03-04
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictName=").append(dictName);
        sb.append(", dictItemName=").append(dictItemName);
        sb.append(", dictSrot=").append(dictSrot);
        sb.append(", dictStatus=").append(dictStatus);
        sb.append("]");
        return sb.toString();
    }
}