package testcases.material;

import domain.detail.material.SearchDetail;
import page.material.search.SpecialNormalDetailSearchPage;
import util.PageStore;

public class Search {
	
	PageStore pageStore;
	SpecialNormalDetailSearchPage onSearchPage;

	public Search(PageStore pageStore) {
		this.pageStore = pageStore;
		onSearchPage = pageStore.get(SpecialNormalDetailSearchPage.class);
	}

	public void SearchTextInBing_Second(SearchDetail searchDetail)
	{		
		onSearchPage.enterCreatedDateFromFieldAs(searchDetail.getCreatedDateFrom());
		onSearchPage.enterCreatedDateToFieldAs(searchDetail.getCreatedDateTo());
		onSearchPage.clickSearchButton();
		onSearchPage.Validate.verifyRangDateWarning();
	}
}
