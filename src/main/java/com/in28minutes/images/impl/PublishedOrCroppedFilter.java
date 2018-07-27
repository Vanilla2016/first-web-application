package com.in28minutes.images.impl;

import java.util.Map;

import com.in28minutes.interfaces.ResultsFilter;
import uk.co.jdwilliams.dams.documentum.services.search.Row;

public class PublishedOrCroppedFilter implements ResultsFilter {

	int croppedInd=-1;
	int operationPending=-1;
	int publishedForWebInd=-1;
	@Override
	public boolean rowAllowed(Row row, Map<String, Integer> colNames) {
		if(croppedInd==-1){
			croppedInd=colNames.get("croppedInd");
			operationPending=colNames.get("operationPending");
			publishedForWebInd=colNames.get("publishedForWebInd");
		}
		String [] r = row.getColumnValue();
		boolean cropped = "1".equals(r[croppedInd]);
		boolean pending = "1".equals(r[operationPending]);
		boolean published = "1".equals(r[publishedForWebInd]);
		return cropped && !pending || published;
	}

}
