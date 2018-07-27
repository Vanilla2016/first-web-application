package com.in28minutes.images.impl;

import java.util.Map;

import com.in28minutes.interfaces.ResultsFilter;

import uk.co.jdwilliams.dams.documentum.services.search.Row;

public class DefaultResultsFilter implements ResultsFilter {

	@Override
	public boolean rowAllowed(Row row, Map<String, Integer> colNames) {
		return true;
	}

}
