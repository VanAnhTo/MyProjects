package domain.builder.material;

import domain.detail.material.SearchDetail;
import page.material.add.SearchPage.OrderTypeEnum;

public class SearchDetailBuilder {
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

	public SearchDetailBuilder() {
		orderType = "SPECIALOFNORMAL";
		certificateNumber = "";
		materialName = "";
		issuedDateFrom = "";
		issuedDateTo = "";
		createdDateFrom = "";
		createdDateTo = "";
		orderNumber = "";
	}

	public SearchDetailBuilder withOrderType(String orderType) {
		this.orderType = orderType;
		return this;
	}

	public SearchDetailBuilder withStatus(String status) {
		this.status = status;
		return this;
	}

	public SearchDetailBuilder withCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
		return this;
	}

	public SearchDetailBuilder withMaterialName(String materialName) {
		this.materialName = materialName;
		return this;
	}

	public SearchDetailBuilder withIssuedDateFrom(String issuedDateFrom, String issuedDateTo) {
		this.issuedDateFrom = issuedDateFrom;
		this.issuedDateTo = issuedDateTo;
		return this;
	}

	public SearchDetailBuilder withCreatedDate(String createdDateFrom, String createdDateTo) {
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
		return this;
	}

	public SearchDetailBuilder withOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public SearchDetailBuilder withSubstance(String substance) {
		this.substance = substance;
		return this;
	}
	public SearchDetail build() {
		return new SearchDetail(orderType, status, certificateNumber, materialName, issuedDateFrom,
				issuedDateTo, createdDateFrom, createdDateTo, orderNumber,substance);
	}
}
