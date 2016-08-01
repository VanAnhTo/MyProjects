package domain.detail.material;



public class SearchDetail {

	private String orderType;
	private String status;
	private String certificateNumber;
	private String materialName;

	private String issuedDateFrom;
	private String issuedDateTo;
	private String createdDateFrom;
	private String createdDateTo;
	private String orderNumber;
	private String substance;

	public enum OrderTypeEnum {
		ALL(1), SPECIALOFNORMAL(2), NORMAL(3);
		private int value;

		private OrderTypeEnum(int value) {
			this.value = value;
		}
	}

	public enum StatusEnum {
		ALL(1);
		private int value;

		private StatusEnum(int value) {
			this.value = value;
		}
	}

	public enum SubstanceEnum {
		ALL(1);
		private int value;

		private SubstanceEnum(int value) {
			this.value = value;
		}
	}

	public SearchDetail(String orderType, String status, String certificateNumber, String materialName,
			String issuedDateFrom, String issuedDateTo, String createdDateFrom, String createdDateTo,
			String orderNumber, String substance) {

		this.orderType = orderType;
		this.status = status;
		this.certificateNumber = certificateNumber;
		this.materialName = materialName;
		this.issuedDateFrom = issuedDateFrom;
		this.issuedDateTo = issuedDateTo;
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
		this.orderNumber = orderNumber;
		this.substance = substance;
	}

	public String getOrderType() {
		return orderType;
	}

	public String getStatus() {
		return status;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public String getMaterialName() {
		return materialName;
	}

	public String getIssuedDateFrom() {
		return issuedDateFrom;
	}

	public String getIssuedDateTo() {
		return issuedDateTo;
	}

	public String getCreatedDateFrom() {
		return createdDateFrom;
	}

	public String getCreatedDateTo() {
		return createdDateTo;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getSubstance() {
		return substance;
	}

}
