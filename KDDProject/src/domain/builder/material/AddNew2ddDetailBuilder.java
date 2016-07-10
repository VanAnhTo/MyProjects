package domain.builder.material;

import java.util.List;

import domain.detail.material.AddNew2ddDetails;
import domain.detail.material.MaterialDetail;

public class AddNew2ddDetailBuilder {
	private String fileNumber;
	private String signWhere;
	private List<MaterialDetail> materialDetailList;
	/*
	 * private String materialName; private String contentMaterial; private
	 * String unitMaterial; private String amountMaterial; private String
	 * qualityMaterial; private String registrationNumber; private String
	 * contentration; private String contentImport;
	 */

	public AddNew2ddDetailBuilder withFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
		return this;
	}

	public AddNew2ddDetailBuilder withSignWhere(String signWhere) {
		this.signWhere = signWhere;
		return this;
	}

	public AddNew2ddDetailBuilder withMaterialDetailList(List<MaterialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
		return this;
	}

	public AddNew2ddDetails build() {
		return new AddNew2ddDetails(fileNumber, signWhere, materialDetailList);
	}

}
