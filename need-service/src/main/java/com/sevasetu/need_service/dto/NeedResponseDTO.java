package com.sevasetu.need_service.dto;

public class NeedResponseDTO {
	
	 private Long id;
	    private String title;
	    private String category;
	    private Integer quantity;
	    private String unit;
	    private String status;
	    private Long organizationId;
	    private String description;
		private Integer targetAmount;
		private Integer raisedAmount;
		private String priority;
		private String createdAt; //Need create hone ka time
		private String updatedAt;
	    
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

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public String getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}

		public NeedResponseDTO() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
	    
	    

}
