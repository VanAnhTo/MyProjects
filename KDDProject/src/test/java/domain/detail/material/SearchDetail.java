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

	public SearchDetail() {
		int orderType = OrderTypeEnum.valueOf(getOrderType()).value;
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
