package com.in28minutes.actions;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

public class GetImagesAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
				
	HttpServletRequest request;
	
		@Override
		public String execute() {
			getImages();
			return SUCCESS;
		}
		
		private String getImages(){
			
			//String function = request.GetVar("function");
			//boolean json="json".equals(ics.GetVar("style"));
			//System.out.println("FUNCTION :"+getServletRequest().getParameter("function"));
			//System.out.println("STYLE :"+Boolean.parseBoolean(getServletRequest().getParameter("style")));
			//System.out.println("CHANNEL :"+getServletRequest().getParameter("channel"));
			String error = null;
			
			System.out.println(Boolean.getBoolean(getServletRequest().getParameter("json"))?"{\"data\": [":"<data>"+getServletRequest().getParameter("channel"));//.println(json?"{\"data\": [":"<data>");
		//	try{
				/* functions understood are:
					IMG_ALL load the images as specified by 
						the product_code, channel lifestyle colour and 
						season.
					IMG_BY_ID load usage related to the given image
					IMG_BY_ID_TAGGED_CROPPED
					IMG_CROPPED_ORIGINALS
					IMG_COL_ALL
					IMG_TAGGED load the images as specified by 
						the product_code, channel lifestyle colour and 
						season but only where there has been a tag other than UNALLOCATED.
					INITIAL_LOGOS load logo data according to product code and locale
					SEARCH_LOGOS load logos according to search string.
				*/
				/*
				RequestWrapper requester = new RequestWrapper(ics, function);
				requester.addIn("product_code", "productcode", false);
				
				Map<String, String> shotTypeMap = new HashMap<String, String>();
				for (String[] x: new String[][]{
					{"a", "Main Shot (Modelled)"},
					{"b", "Inset (Modelled)"},
					{"c", "Still Life"},
					{"d", "Front Cover"},
					{"f", "Background"},
					{"g", "Marketing Shot"},
					{"l", "Landing Page Shot"},
					{"r", "Remail"},
					{"s", "Web Shot (Still Life)"},
					{"w", "Web Shot"},
					{"u", "Scamp"}}){
					shotTypeMap.put(x[0], x[1]);
				}
				//Returns comma separated string of shot type tags!
				ResultsFilter filter = new DefaultResultsFilter();
				boolean first = true;
				if (function == null || 
				    function.equals("IMG_TAGGED") || 
				    function.equals("IMG_COL_ALL") || 
				    function.equals("IMG_ALL")){
					requester.addEqual("channel", "channel");
					requester.addEqual("intended_channel", "intended");
					String shotType = request.;//ics.GetVar("shotType")
					if (shotType != null && shotType.trim().length()>0){
						StringBuilder st=new StringBuilder();
						for (String sti: ics.GetVar("shotType").split(",")){
							if (st.length()!=0) st.append(",");
							st.append(shotTypeMap.get(sti));
						}
						requester.addInValue("shot_type", st.toString(), false);
					}
					String postfilter = ics.GetVar("postfilter");
					if ("PUBLISHED_OR_CROPPED".equals(postfilter)) filter = new PublishedOrCroppedFilter();
					else if ("NOT_UNALLOCATED".equals(postfilter)) filter = new NoUnallocatedFilter();
					String readLifestyle = ics.GetVar("lifestyle");
					requester.addEqual("lifestyle", "lifestyle");
					requester.addIn("colour", "colour", false);
					requester.addEqual("season", "season");
					requester.addEqual("locale", "localecode");
					if (function.equals("IMG_TAGGED")){
						filter = new NoUnallocatedFilter();
					}
					if (function.equals("IMG_COL_ALL")){
						for (int i=1; i<10; i++){
							requester.addEqual("c0"+i+"_product_code", "productcode");
							requester.addIn("c0"+i+"_colour", "colour", false);
						}
						for (int i=10; i<21; i++){
							requester.addEqual("c"+i+"_product_code", "productcode");
							requester.addIn("c"+i+"_colour", "colour", false);
						}
					}
				}else if (function.equals("IMG_CROPPED_ORIGINALS")){
					requester.addIn("original_filename", "originals", false);
					filter = new PublishedOrCroppedOrCropPendingWithFilenameFilter(ics.GetVar("originals"));
				}else if (function.equals("IMG_BY_ID_TAGGED_CROPPED")){
					// originally this was inteneded to only
					// update images that are already on the screen, 
					// but by ignoring the id list we get to add new images
					//requester.addIn("asset_id", "ids", false);
					filter = new PublishedOrCroppedTaggedOrWithIdFilter(ics.GetVar("ids"), 
								ics.GetVar("productcode"), 
								ics.GetVar("lifestyle"), 
								ics.GetVar("season"), 
								ics.GetVar("locale"));
				}else if (function.equals("IMG_BY_ID")){
					requester.addIn("id", "ids", false);
				}else if (function.equals("INITIAL_LOGOS")){
					requester.addEqual("locale", "localecode");
				}else if (function.equals("SEARCH_LOGOS")){
					requester.addLikeFragmentRequiredLC("name_search", "name_search");
					requester.addLikeFragmentRequiredLC("keyword_search", "name_search");
				}else{
					error="Given function ("+function+") is not valid";
				}
				
				if (error == null){
					final ResultParser res = new ResultParser(requester.read(), ics, filter);
					if (res.isError()){
						error = res.getError();
					}else{
						boolean logo=function.contains("LOGO");
						for (ResultParser.RowWrapper r: res){
							if (r != null){
								if (json){
									if (first) first = false;
									else out.println(",");
									String s = r.toJSONString(ics, logo);
									out.println(s);
								}else{
									out.println(r.toXMLString(ics, logo));
								}
							}else{
								ics.LogMsg("null value for row indx ="+res.index+", rows="+
											(res.rows!=null?res.rows.length:"null"));
							}
						}
					}
				}
			}catch (Throwable e){
				if (error == null) error = "Problem accessing Documentum: "+e.getMessage()+": "+e.getClass().getName();
			}
			if (error != null){
				ics.LogMsg("Function: "+function+"; Error: "+error);
				error=error.replaceAll("\"", "'");
				error=error.replaceAll("\r\n|\n\r|\r|\n", "\\n");
			}
			if (json){
				out.println("]");
				if (error != null) out.println(",\n\"error\": \""+error+"\"");
				out.println("}");
			}else{
				if (error != null)out.println("<error>"+error+"</error>\n");
				out.println("</data>");
			}
				 */
			return "SHIT";
		}

		private ServletRequest getServletRequest() {
			return request;
		}

		@Override
		public void setServletRequest(HttpServletRequest arg0) {
			this.request = arg0;
		}
	}
