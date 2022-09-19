package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

public class TblHolding {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "日期",required = false, example = "2022-09-16 17:36:30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date theDate;

    @ApiModelProperty(value = "组合ID",required = false)
    private String nodeId;

    @ApiModelProperty(value = "证券代码",required = false)
    private String symbol;

    @ApiModelProperty(value = "市场代码",required = false)
    private String marketNo;

    @ApiModelProperty(value = "公允价值",required = false)
    private BigDecimal estimateValue;

    @ApiModelProperty(value = "持仓数量",required = false)
    private BigDecimal holdingUnits;

    @ApiModelProperty(value = "资产类型ID",required = false)
    private String assetTypeId;

    @ApiModelProperty(value = "买入收益率",required = false)
    private BigDecimal redemptionYeild;

    @ApiModelProperty(value = "创建人",required = true)
    private String createBy;

    @ApiModelProperty(value = "创建时间",required = true, example = "2022-09-16 17:36:30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "修改人",required = true)
    private String updateBy;

    @ApiModelProperty(value = "修改时间",required = true, example = "2022-09-16 17:36:30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 日期
     * @return the_date 日期
     */
    public Date getTheDate() {
        return theDate;
    }

    /**
     * 日期
     * @param theDate 日期
     */
    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    /**
     * 组合ID
     * @return node_id 组合ID
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * 组合ID
     * @param nodeId 组合ID
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    /**
     * 证券代码
     * @return symbol 证券代码
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 证券代码
     * @param symbol 证券代码
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * 市场代码
     * @return market_no 市场代码
     */
    public String getMarketNo() {
        return marketNo;
    }

    /**
     * 市场代码
     * @param marketNo 市场代码
     */
    public void setMarketNo(String marketNo) {
        this.marketNo = marketNo == null ? null : marketNo.trim();
    }

    /**
     * 公允价值
     * @return estimate_value 公允价值
     */
    public BigDecimal getEstimateValue() {
        return estimateValue;
    }

    /**
     * 公允价值
     * @param estimateValue 公允价值
     */
    public void setEstimateValue(BigDecimal estimateValue) {
        this.estimateValue = estimateValue;
    }

    /**
     * 持仓数量
     * @return holding_units 持仓数量
     */
    public BigDecimal getHoldingUnits() {
        return holdingUnits;
    }

    /**
     * 持仓数量
     * @param holdingUnits 持仓数量
     */
    public void setHoldingUnits(BigDecimal holdingUnits) {
        this.holdingUnits = holdingUnits;
    }

    /**
     * 资产类型ID
     * @return asset_type_id 资产类型ID
     */
    public String getAssetTypeId() {
        return assetTypeId;
    }

    /**
     * 资产类型ID
     * @param assetTypeId 资产类型ID
     */
    public void setAssetTypeId(String assetTypeId) {
        this.assetTypeId = assetTypeId == null ? null : assetTypeId.trim();
    }

    /**
     * 买入收益率
     * @return redemption_yeild 买入收益率
     */
    public BigDecimal getRedemptionYeild() {
        return redemptionYeild;
    }

    /**
     * 买入收益率
     * @param redemptionYeild 买入收益率
     */
    public void setRedemptionYeild(BigDecimal redemptionYeild) {
        this.redemptionYeild = redemptionYeild;
    }

    /**
     * 创建人
     * @return create_by 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return update_by 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 修改人
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbg.generated 2022-09-16
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
        TblHolding other = (TblHolding) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTheDate() == null ? other.getTheDate() == null : this.getTheDate().equals(other.getTheDate()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getSymbol() == null ? other.getSymbol() == null : this.getSymbol().equals(other.getSymbol()))
            && (this.getMarketNo() == null ? other.getMarketNo() == null : this.getMarketNo().equals(other.getMarketNo()))
            && (this.getEstimateValue() == null ? other.getEstimateValue() == null : this.getEstimateValue().equals(other.getEstimateValue()))
            && (this.getHoldingUnits() == null ? other.getHoldingUnits() == null : this.getHoldingUnits().equals(other.getHoldingUnits()))
            && (this.getAssetTypeId() == null ? other.getAssetTypeId() == null : this.getAssetTypeId().equals(other.getAssetTypeId()))
            && (this.getRedemptionYeild() == null ? other.getRedemptionYeild() == null : this.getRedemptionYeild().equals(other.getRedemptionYeild()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     *
     * @mbg.generated 2022-09-16
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTheDate() == null) ? 0 : getTheDate().hashCode());
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        result = prime * result + ((getMarketNo() == null) ? 0 : getMarketNo().hashCode());
        result = prime * result + ((getEstimateValue() == null) ? 0 : getEstimateValue().hashCode());
        result = prime * result + ((getHoldingUnits() == null) ? 0 : getHoldingUnits().hashCode());
        result = prime * result + ((getAssetTypeId() == null) ? 0 : getAssetTypeId().hashCode());
        result = prime * result + ((getRedemptionYeild() == null) ? 0 : getRedemptionYeild().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated 2022-09-16
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", theDate=").append(theDate);
        sb.append(", nodeId=").append(nodeId);
        sb.append(", symbol=").append(symbol);
        sb.append(", marketNo=").append(marketNo);
        sb.append(", estimateValue=").append(estimateValue);
        sb.append(", holdingUnits=").append(holdingUnits);
        sb.append(", assetTypeId=").append(assetTypeId);
        sb.append(", redemptionYeild=").append(redemptionYeild);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}