package domain;

import java.util.List;

public class AddNew2ddDetails {
	
	private String fileNumber;
	private String signWhere;
	
	private List<MaterialDetail> materialDetailList;
	
	public AddNew2ddDetails(String fileNumber,String signWhere,
			List<MaterialDetail> materialDetailList)
	{
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
