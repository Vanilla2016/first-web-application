package com.in28minutes.images.impl;

import java.util.Map;
import uk.co.jdwilliams.dams.documentum.services.search.Row;

public class PublishedOrCroppedOrCropPendingWithFilenameFilter 
extends PublishedOrCroppedOrCropPendingFilter {
	final String filenames;
	int origFileName=-1;
	PublishedOrCroppedOrCropPendingWithFilenameFilter(String filenames){
		this.filenames = filenames;
	}
	@Override
	public boolean rowAllowed(Row row, Map<String, Integer> colNames){
		if(origFileName==-1){
			origFileName=colNames.get("originalFileName");
		}
		String r[] = row.getColumnValue();
		String fn = r[origFileName];
		return (fn!=null && filenames.contains(fn) && super.rowAllowed(row, colNames));
	}
}
