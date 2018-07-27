package com.in28minutes.images.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.in28minutes.interfaces.ResultsFilter;
import uk.co.jdwilliams.dams.documentum.services.search.Row;
import uk.co.jdwilliams.searchservice.api.service.enums.TagsEnum;

public class PublishedOrCroppedTaggedOrWithIdFilter implements ResultsFilter {

	int croppedInd=-1;
	int operationPending=-1;
	int publishedForWebInd=-1;
	int usageType=-1;
	int asset_id=-1;
	int useageproductcode_id=-1;
	int lifestyle_id=-1;
	int season_id=-1;
	int locale_id=-1;
	String productcode;
	String lifestyle;
	String season;
	String locale;
	Set<String> ids = new HashSet<String>();
	PublishedOrCroppedTaggedOrWithIdFilter(String ids, String lifestyle, 
											String season, String locale){
			if(ids!=null){
				for(String id: ids.split(",")){
					this.ids.add(id);
				}
			}
			this.productcode=productcode;
			this.lifestyle=lifestyle.length()>2?lifestyle.substring(lifestyle.length()-2):lifestyle;
			this.season=season;
			this.locale=locale;
		}
	
	@Override
	public boolean rowAllowed(Row row, Map<String, Integer> colNames) {
		if(croppedInd==-1){
			croppedInd = colNames.get("croppedInd"); 
			operationPending = colNames.get("operationPending"); 
			publishedForWebInd = colNames.get("publishedForWebInd"); 
			usageType = colNames.get("usageType"); 
			asset_id = colNames.get("asset_id"); 
			useageproductcode_id = colNames.get("useageproductcode_id"); 
			lifestyle_id = colNames.get("lifestyle"); 
			season_id = colNames.get("season"); 
			locale_id = colNames.get("locale"); 
		}
		String[] r = row.getColumnValue();
		boolean cropped = "1".equals(r[croppedInd]);
		boolean pending = "1".equals(r[operationPending]);
		boolean published = "1".equals(r[publishedForWebInd]);
		boolean used = TagsEnum.tagByDocId(r[usageType])!=TagsEnum.UNALLOCATED &&
					productcode.equals(r[useageproductcode_id]) &&
					lifestyle.equals(r[lifestyle_id]) && 
					season.equals(r[season_id]) && 
					locale.equals(r[locale_id]); 
		return used || ids.contains(r[asset_id]); 
	}
}
