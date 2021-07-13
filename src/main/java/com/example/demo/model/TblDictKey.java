package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public class TblDictKey {
    @ApiModelProperty(value = "字典码")
    private String dictCode;

    @ApiModelProperty(value = "数据字典码")
    private String dictItemNo;

    /**
     * 字典码
     * @return dict_code 字典码
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 字典码
     * @param dictCode 字典码
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * 数据字典码
     * @return dict_item_no 数据字典码
     */
    public String getDictItemNo() {
        return dictItemNo;
    }

    /**
     * 数据字典码
     * @param dictItemNo 数据字典码
     */
    public void setDictItemNo(String dictItemNo) {
        this.dictItemNo = dictItemNo == null ? null : dictItemNo.trim();
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
        TblDictKey other = (TblDictKey) that;
        return (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictItemNo() == null ? other.getDictItemNo() == null : this.getDictItemNo().equals(other.getDictItemNo()));
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
        sb.append(", dictCode=").append(dictCode);
        sb.append(", dictItemNo=").append(dictItemNo);
        sb.append("]");
        return sb.toString();
    }
}