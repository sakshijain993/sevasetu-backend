
package com.sevasetu.need_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class NeedRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Category is required")
    private String category;

    // Physical needs ke liye quantity required ho sakti hai.
    // Money needs mein null allowed hai.
    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;

    private String unit;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Organization ID is required")
    @Positive(message = "Organization ID must be positive")
    private Long organizationId;

    @NotBlank(message = "Description is required")
    private String description;

    // Money-related needs ke liye optional
    @Positive(message = "Target amount must be greater than zero")
    private Integer targetAmount;

    @PositiveOrZero(message = "Raised amount cannot be negative")
    private Integer raisedAmount;

    @NotBlank(message = "Priority is required")
    private String priority;

    public NeedRequestDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Integer targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Integer getRaisedAmount() {
        return raisedAmount;
    }

    public void setRaisedAmount(Integer raisedAmount) {
        this.raisedAmount = raisedAmount;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
