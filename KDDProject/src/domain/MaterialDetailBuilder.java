package domain;

public class MaterialDetailBuilder {

	private String materialName;
	private String contentMaterial;
	private String unitMaterial;
	private String amountMaterial;
	private String qualityMaterial;
	private String registrationNumber;
	private String contentration;
	private String contentImport;

	public MaterialDetailBuilder withMaterialName(String materialName) {
		this.materialName = materialName;
		return this;
	}

	public MaterialDetailBuilder withContenMaterial(String contentMaterial) {
		this.contentMaterial = contentMaterial;
		return this;
	}

	public MaterialDetailBuilder withUnitMaterial(String unitMaterial) {
		this.unitMaterial = unitMaterial;
		return this;
	}

	public MaterialDetailBuilder withQualityMateriall(String qualityMaterial) {
		this.qualityMaterial = qualityMaterial;
		return this;
	}

	public MaterialDetailBuilder withAmountMaterial(String amountMaterial) {
		this.amountMaterial = amountMaterial;
		return this;
	}

	public MaterialDetailBuilder withRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
		return this;
	}

	public MaterialDetailBuilder withContentration(String contentration) {
		this.contentration = contentration;
		return this;

	}

	public MaterialDetailBuilder withContentImportl(String contentImport) {
		this.contentImport = contentImport;
		return this;
	}
	
	public MaterialDetail build() {
		return new MaterialDetail(materialName, contentMaterial,  unitMaterial, amountMaterial, qualityMaterial,registrationNumber,  contentration,  contentImport);
	}

}
