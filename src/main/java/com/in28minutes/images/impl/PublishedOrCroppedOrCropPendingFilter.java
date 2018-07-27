package com.in28minutes.images.impl;

import java.util.Map;

import uk.co.jdwilliams.dams.documentum.services.search.Row;
import com.in28minutes.interfaces.ResultsFilter;

public class PublishedOrCroppedOrCropPendingFilter implements ResultsFilter {

		int croppedInd=-1;
		int operationPending=-1;
		int publishedForWeb=-1;
		@Override
		public boolean rowAllowed(Row row, Map<String, Integer> colNames) {
			if(croppedInd==-1){
				croppedInd = colNames.get("croppedInd");
				publishedForWeb = colNames.get("publishedForWeb");
			}
		String[] r = row.getColumnValue();
		boolean cropped = "1".equals(r[croppedInd]);
		boolean published = "1".equals(r[publishedForWeb]);
		return cropped || published;
		}
	}
