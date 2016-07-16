package domain.detail.material;

import java.util.List;

public class PageDetail {

	private String fileNumber;
	private String signWhere;

	private List<MaterialDetail> materialDetailList;

	public PageDetail(String fileNumber, String signWhere, List<MaterialDetail> materialDetailList) {
		this.fileNumber = fileNumber;
		this.signWhere = signWhere;
		this.materialDetailList = materialDetailList;

	}

	public String getFileNumber() {
		return fileNumber;
	}

	public String getSignWhere() {
		return signWhere;
	}

	public List<MaterialDetail> getMaterialDetailList() {
		return materialDetailList;
	}

}
