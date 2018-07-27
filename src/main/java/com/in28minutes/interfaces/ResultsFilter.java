package com.in28minutes.interfaces;

import java.util.Map;

import uk.co.jdwilliams.dams.documentum.services.search.Row;

public interface ResultsFilter{
	boolean rowAllowed(Row row, Map<String, Integer> colNames);
}