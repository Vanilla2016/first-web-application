package com.in28minutes.images.results;

import java.util.HashMap;
import java.util.Map;

import uk.co.jdwilliams.dams.documentum.services.search.Request;
import uk.co.jdwilliams.dams.documentum.services.search.Results;
import uk.co.jdwilliams.searchservice.api.service.DocumentumSearchServiceAPI;
import uk.co.jdwilliams.searchservice.api.service.DocumentumSearchServiceAPI.RequestHolder;
import uk.co.jdwilliams.searchservice.impl.service.DocumentumSearchService;



class RequestWrapper{
	final RequestHolder reqH;
	final DocumentumSearchServiceAPI instance;
    
	/* Maps the initialized code to the relevant DocumentumSearchService query*/
    Map<String, String> functionToQueryName = new HashMap<String, String>();
    {
		  functionToQueryName.put("IMG_ALL", "WebImageUsage");
		  functionToQueryName.put("IMG_COL_ALL", "WebCompositeImageColourUsage");
		  functionToQueryName.put("IMG_TAGGED", "WebImageUsage");
		  functionToQueryName.put("INITIAL_LOGOS", "WebLogoUsage");
		  functionToQueryName.put("SEARCH_LOGOS", "WebLogoSearch");
		  functionToQueryName.put("IMG_BY_ID", "WebImageUsage");
		  functionToQueryName.put("IMG_BY_ID_TAGGED_CROPPED", "WebImageUsage");
		  functionToQueryName.put("IMG_CROPPED_ORIGINALS", "WebImageUsage");
    }
	//final ICS ics;
	/*
	 * Seems to wrap the request to give utility layer between calling 
	 * element and  RequestHolder
	 */
	RequestWrapper(String function){//final ICS ics, 
		//this.ics = ics;
		instance = DocumentumSearchService.getInstance();
		reqH = instance.constructRequest(functionToQueryName.get(function));
	}
	
	void addIn(final String name, final String valueName, boolean addEmpty)
	throws Exception{
		addInValue(name, request(valueName), addEmpty);//ics.GetVar(valueName)
	}
	
	void addInValue(final String name, final String value, boolean addEmpty)
	throws Exception{
		if (value != null){
			if (value.contains(",")){
				StringBuilder val = new StringBuilder();
				List<String> vals = new ArrayList<String>();
				for (String v: value.trim().split("\\s*,\\s*")){
					vals.add(v);
				}
				if (addEmpty) vals.add("");
				//Adds list
				reqH.addIn(name, vals);
			}else{
				//Adds String
				reqH.addEqual(name, value);
			}
		}
	}
	void addEqual(final String name, final String valueName)
	throws Exception{
		reqH.addEqual(name, ics.GetVar(valueName));
	}
	void addEqualVal(final String name, final String value)
	throws Exception{
		reqH.addEqual(name, value);
	}

	void addLikeFragmentRequiredLC(final String name, final String valueName)
	throws Exception{
		String v = ics.GetVar(valueName);
		if (v==null || v.trim().length()==0){
			v="*";
		}
		reqH.addLike(name, ("%"+v.toLowerCase().replaceAll("\\*", "%")+"%").replaceAll("%+", "%"));
	}

	void addNotEqual(final String name, final String valueName)
	throws Exception{
		reqH.addNotEqual(name, ics.GetVar(valueName));
	}
	//This does the actual Documentum call...
	Results read() throws Throwable{
		try{
			Request req = reqH.getRequest();
			Results r= instance.getDataProcessorResults(req);
			return r;
		}catch(Throwable e){
			e.printStackTrace();
			throw e;
		}
		
	}
}