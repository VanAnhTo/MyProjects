package domain.builder.material;

import java.util.List;

import domain.detail.material.PageDetail;
import domain.detail.material.MaterialDetail;

public class PageDetailBuilder {

	private String fileNumber;
	private String signWhere;
	private List<MaterialDetail> materialDetailList;

	public PageDetailBuilder() {
	}

	public PageDetailBuilder withFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
		return this;
	}

	public PageDetailBuilder withSignWhere(String signWhere) {
		this.signWhere = signWhere;
		return this;
	}

	public PageDetailBuilder withMaterialDetailList(List<MaterialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
		return this;
	}

	public PageDetail build() {

		return new PageDetail(fileNumber, signWhere, materialDetailList);
	}

}
