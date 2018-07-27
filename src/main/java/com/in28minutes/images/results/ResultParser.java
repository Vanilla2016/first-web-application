package com.in28minutes.images.results;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

import com.in28minutes.images.impl.DefaultResultsFilter;
import com.in28minutes.interfaces.ResultsFilter;

import uk.co.jdwilliams.dams.documentum.services.search.Column;
import uk.co.jdwilliams.dams.documentum.services.search.Results;
import uk.co.jdwilliams.dams.documentum.services.search.Row;

import uk.co.jdwilliams.searchservice.api.service.enums.TagsEnum;

/* start ResultParser - Takes the RESULTS, applies the filter, 
 * returns the String of either XML or JSON structured data */
class ResultParser implements 
			Iterable<ResultParser.RowWrapper>, 
			Iterator<ResultParser.RowWrapper>{
	class RowWrapper{
		final Row row;
		RowWrapper(Row row){
			this.row = row;
		}
		String get(int index){
			return row.getColumnValue()[index];
		}
		String get(String index){
			Integer ind = map.get(index); 
			if (ind == null) return "";
			return get(ind);
		}
		String getNQFilename(){
			if (map.get("filename")==null){
				return getNQ("name");
			}else{
				return getNQ("filename");
			}
		}
		String getNQLifestyle(){
			String res = getNQ("lifestyle");
			if (res != null && res.length()==2)
				res = "1"+res;
			return res;
		}
		String getNQ(int index){
			if (index>=row.getColumnValue().length)
				return "";
			else{
				String raw = row.getColumnValue()[index];
				if (raw==null) return "";
				String res = StringEscapeUtils.escapeJava(raw.replaceAll("\"", "&quot;").replaceAll("'", "&#39;"));
				return res;
			}
		}
		String getNQ(String index){
			Integer ind = map.get(index); 
			if (ind == null) return "";
			return getNQ(ind);
		}
		String getNQLines(String index){
			String v = getNQ(index);
			StringBuilder sb = new StringBuilder("[");
			for (String l: v.split("\\\\n")){
				if (sb.length()!=1) sb.append(",");
				sb.append("\"").append(l).append("\"");
			}
			sb.append("]");
			return sb.toString();
		}
		
		String getXFilename(){
			if (map.get("filename")==null){
				return getX("name");
			}else{
				return getX("filename");
			}
		}
		String getXLifestyle(){
			String res = getX("lifestyle");
			if (res != null && res.length()==2)
				res = "1"+res;
			return res;
		}
		String getX(int index){
			String raw = row.getColumnValue()[index];
			if (raw==null) return "";
			return StringEscapeUtils.escapeXml(raw.replaceAll("'", "&#39;").
												   replaceAll("<", "&lt;"));
		}
		String getX(String index){
			Integer i = map.get(index);
			if (i==null) return "";
			return getX(i);
		}
		public String toXMLString(boolean logo){//ICS ics, 
			StringBuilder res = new StringBuilder();
			if (logo)
				res.append("<item id=\"").append(getX("asset_id")).append("-").
										  append(getX("locale")).append("-").
										  append(getX("usageproduct")).append("\">\n");
			else
				res.append("<item id=\"").append(getX("asset_id")).append("-").
										  append(getXLifestyle()).append("-").
										  append(getX("season")).append("-").
										  append(getX("locale")).append("-").
										  append(getX("usageproduct")).append("\">\n");
			res.append("<imageid>").append(getX("asset_id")).append("</imageid>\n");
			res.append("<productcode>").append(getX("product_code")).append("</productcode>\n");
			res.append("<usageproductcode>").append(getX("usageproduct")).append("</usageproductcode>\n");
			res.append("<image_src>").append(getX("url_small")).append("</image_src>\n");
			res.append("<lifestyle>").append(getXLifestyle()).append("</lifestyle>\n");
			res.append("<season>").append(getX("season")).append("</season>\n");
			res.append("<tag>").append(TagsEnum.tagByDocId(get("usagetype")).getWpcTag()).append("</tag>\n");
			res.append("<colour>").append(getX("colour")).append("</colour>\n");
			res.append("<channel>").append(getX("channel")).append("</channel>\n");
			res.append("<hover_image_src>").append(getX("url_large")).append("</hover_image_src>\n");
			res.append("<filename>").append(getXFilename()).append("</filename>\n");

			res.append("<returnedFromReproInd>").append(getX("returnedFromReproInd")).append("</returnedFromReproInd>\n");
			res.append("<sentToReproInd>").append(getX("sentToReproInd")).append("</sentToReproInd>\n");
			res.append("<reproHistoryInd>").append(getX("returnedFromReproHistoryInd")).append("</reproHistoryInd>\n");
			res.append("<amendOperationPending>").append(getX("amendOperationPending")).append("</amendOperationPending>\n");
			res.append("<cloneRequested>").append(getX("cloneRequested")).append("</cloneRequested>\n");
			res.append("<colourTweakRequested>").append(getX("colourTweakRequested")).append("</colourTweakRequested>\n");
			res.append("<cutoutRequested>").append(getX("cutoutRequested")).append("</cutoutRequested>\n");
			res.append("<extendedRequested>").append(getX("extendedRequested")).append("</extendedRequested>\n");
			res.append("<resizeRequested>").append(getX("resizeRequested")).append("</resizeRequested>\n");
			res.append("<recolourOperationPending>").append(getX("recolourOperationPending")).append("</recolourOperationPending>\n");
			res.append("<recolourRequested>").append(getX("recolourRequested")).append("</recolourRequested>\n");

			res.append("<fiveStarInd>").append(getX("fiveStarInd")).append("</fiveStarInd>\n");
			res.append("<masterVersionInd>").append(getX("masterVersionInd")).append("</masterVersionInd>\n");
			res.append("<publishedForWebInd>").append(getX("publishedForWebInd")).append("</publishedForWebInd>\n");
			res.append("<cropped>").append(getX("croppedInd")).append("</cropped>\n");
			res.append("<pending>").append(getX("cropOperationPending")).append("</cropped>\n");
			res.append("<available>").append(getX("assetAvailable")).append("</available>\n");
			res.append("<locale>").append(getX("locale")).append("</locale>\n");
			res.append("<comments>").append(getX("comments")).append("</comments>\n");
			res.append("</item>");
			return res.toString();
		}
		public String toJSONString(boolean logo){//ICS ics, 
			StringBuilder res = new StringBuilder();
			if (!logo)
				res.append("{\"id\": \"").append(getNQ("asset_id")).append("-").
										  append(getNQLifestyle()).append("-").
										  append(getNQ("season")).append("-").
										  append(getNQ("locale")).append("-").
										  append(getNQ("usageproduct")).append("\",\n");
			else
				res.append("{\"id\": \"").append(getNQ("asset_id")).append("-").
										  append(getNQ("locale")).append("-").
										  append(getNQ("usageproduct")).append("\",\n");
			res.append("\"imageid\": \"").append(getNQ("asset_id")).append("\",\n");
			res.append("\"productcode\": \"").append(getNQ("product_code")).append("\",\n");
			res.append("\"usageproductcode\": \"").append(getNQ("usageproduct")).append("\",\n");
			res.append("\"image_src\": \"").append(getNQ("url_small")).append("\",\n");
			res.append("\"channel\": \"").append(getNQ("channel")).append("\",\n");
			res.append("\"hover_image_src\": \"").append(getNQ("url_large")).append("\",\n");
			res.append("\"filename\": \"").append(getNQFilename()).append("\",\n");
			res.append("\"orig_filename\": \"").append(getNQ("originalFilename")).append("\",\n");
			res.append("\"locale\": \"").append(getNQ("locale")).append("\"");
			if (!logo){
				res.append(",\n");
				res.append("\"lifestyle\": \"").append(getNQLifestyle()).append("\",\n");
				res.append("\"season\": \"").append(getNQ("season")).append("\",\n");
				res.append("\"tag\": \"").append(TagsEnum.tagByDocId(get("usagetype")).getWpcTag()).append("\",\n");
				res.append("\"colour\": \"").append(getNQ("colour")).append("\",\n");

				res.append("\"sentToReproInd\": \"").append(getNQ("sentToReproInd")).append("\",\n");
				res.append("\"reproHistoryInd\": \"").append(getNQ("returnedFromReproHistoryInd")).append("\",\n");
				res.append("\"returnedFromReproInd\": \"").append(getNQ("returnedFromReproInd")).append("\",\n");
				res.append("\"amendOperationPending\": \"").append(getNQ("amendOperationPending")).append("\",\n");
				res.append("\"cloneRequested\": \"").append(getNQ("cloneRequested")).append("\",\n");
				res.append("\"colourTweakRequested\": \"").append(getNQ("colourTweakRequested")).append("\",\n");
				res.append("\"cutoutRequested\": \"").append(getNQ("cutoutRequested")).append("\",\n");
				res.append("\"extendedRequested\": \"").append(getNQ("extendedRequested")).append("\",\n");
				res.append("\"resizeRequested\": \"").append(getNQ("resizeRequested")).append("\",\n");
				res.append("\"recolourOperationPending\": \"").append(getNQ("recolourOperationPending")).append("\",\n");
				res.append("\"recolourRequested\": \"").append(getNQ("recolourRequested")).append("\",\n");

				res.append("\"fiveStarInd\": \"").append(getNQ("fiveStarInd")).append("\",\n");
				res.append("\"masterVersionInd\": \"").append(getNQ("masterVersionInd")).append("\",\n");
				res.append("\"publishedForWebInd\": \"").append(getNQ("publishedForWebInd")).append("\",\n");
				res.append("\"cropped\": \"").append(getNQ("croppedInd")).append("\",\n");
				res.append("\"pending\": \"").append(getNQ("cropOperationPending")).append("\",\n");
				res.append("\"available\": \"").append(getNQ("assetAvailable")).append("\",\n");
				res.append("\"comments\": ").append(getNQLines("comments")).append("\n");
			}else{
				res.append("\n");
			}
			res.append("}\n");
			return res.toString();
		}
	}
	//final ICS ics;
	final Map<String, Integer> map;
	final Results results;
	final Row[] rows;
	int index = 0;
	final ResultsFilter filter;
	ResultParser(Results results) throws Exception{//, ICS ics
		this(results, new DefaultResultsFilter());//ics, 
	}
	ResultParser(Results results, ResultsFilter filter) throws Exception{//ICS ics, 
		this.filter = filter;
		//this.ics = ics;
		map =  new HashMap<String, Integer>();
		this.results = results;
		int i=0;
		if (results.getResultColumns()==null) throw new Exception("NO-DATA: "+results.getResultMessage());
		for (Column c: results.getResultColumns()){
			map.put(c.getColumnName(), i++);
		}
		rows = results.getResultRows();
	}
	ResultParser(Map<String, Integer> map, Results results, ResultsFilter filter){// ICS ics, 
		this.filter = filter;
		this.map = map;
		this.rows = results.getResultRows();
		this.results = results;
		//this.ics = ics;
	}
	
	public RowWrapper next(){
		if (rows == null) return null;
		while (index<rows.length && !filter.rowAllowed(rows[index], map)) index+=1;
		return index<rows.length?new RowWrapper(rows[index++]):null;
	}
	
	public boolean hasNext(){
		if (rows == null) return false; 
		while (index<rows.length && !filter.rowAllowed(rows[index], map)) index+=1;
		return index<rows.length;
	}
	
	public Iterator<RowWrapper> iterator(){
		return new ResultParser(map, results, filter);//ics, 
	}
	
	public void remove(){}
	
	public boolean isError(){
		return results != null && !"OK".equals(results.getResultMessage());
	}
	
	public String getError(){
		return results==null?"No results":results.getResultMessage();
	}
}
/* end ResultParser */