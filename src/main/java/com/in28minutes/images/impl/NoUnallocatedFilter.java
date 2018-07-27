package com.in28minutes.images.impl;

import java.util.Map;
import com.in28minutes.interfaces.ResultsFilter;

import uk.co.jdwilliams.dams.documentum.services.search.Row;
import uk.co.jdwilliams.searchservice.api.service.enums.TagsEnum;

public class NoUnallocatedFilter implements ResultsFilter {

	@Override
	public boolean rowAllowed(Row row, Map<String, Integer> colNames) {
			String[] r = row.getColumnValue();
			boolean unused = TagsEnum.tagByDocId(r[colNames.get("usageType")])==TagsEnum.UNALLOCATED;
			return !unused;
		}
	}
