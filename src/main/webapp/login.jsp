<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yahooo!!!!!! from JSP</title>
</head>
<%
	String jsResourcePath = request.getContextPath()+ "/js/sources/";
	//System.out.println(jsResourcePath);
%>
<!-- JDW -->
<link rel="stylesheet" type="text/css" href="<%=jsResourcePath%>dhtmlxWindows/codebase/skins/dhtmlxwindows_dhx_skyblue.css"/>
<link rel="stylesheet" type="text/css" href="<%=jsResourcePath%>/dhtmlxMenu/codebase/skins/dhtmlxmenu_dhx_skyblue.css"/>
<link rel="stylesheet" href="<%=jsResourcePath%>dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css"/>
<!-- <link rel="stylesheet" href="sources/dhtmlxGrid/codebase/dhtmlxgrid_skins.css"/> -->
<link rel="stylesheet" href="<%=jsResourcePath%>dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css"/>
<!-- <link rel="stylesheet" href="sources/dhtmlxToolbar/codebase/skins/status_toolbar_layout.css"/> -->
<link rel="stylesheet" href="<%=jsResourcePath%>dhtmlxMenu/codebase/skins/dhtmlxmenu_dhx_skyblue.css"/>
<link rel="stylesheet" href="<%=jsResourcePath%>dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css"/>
<link rel="stylesheet" href="<%=jsResourcePath%>dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css"/>
<link rel="stylesheet" type="text/css" href="<%=jsResourcePath%>dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css"/>
<link rel="stylesheet" type="text/css" href="<%=jsResourcePath%>dhtmlxDataView/codebase/skins/dhtmlxdataview_dhx_skyblue.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/skins/webproofcheck.css"/>
<body>

<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxCommon/codebase/dhtmlxcontainer.js"></script>
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxCommon/codebase/dhtmlxcommon.js"></script>
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxWindows/codebase/dhtmlxwindows.js"></script>

<!-- dataView -->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxCommon/codebase/dhtmlxcore.js"></script>
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxDataView/codebase/dhtmlxdataview.js"></script>
<!-- sources -->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<!--<script type='text/javascript' src='<%=jsResourcePath%>dhtmlxGrid/sources/dhtmlxgridcell.js'></script>-->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxGrid/codebase/ext/dhtmlxgrid_start.js"></script>
<!--<script type='text/javascript' src='sources/dhtmlxGrid/codebase/excells/dhtmlxgrid_excell_combo.js'></script>
<script type='text/javascript' src='sources/dhtmlxGrid/codebase/excells/dhtmlxgrid_excell_link.js'></script>-->

<!-- layout -->
<!-- <script type="text/javascript" src="sources/dhtmlxLayout/codebase/dhtmlxcommon.js"></script> -->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<!-- <script type="text/javascript" src="sources/dhtmlxLayout/codebase/patterns/dhtmlxlayout_pattern4e.js"></script> -->

<!--  menu -->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxMenu/codebase/dhtmlxmenu.js"></script>
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxMenu/codebase/ext/dhtmlxmenu_ext.js"></script>
<!-- <script type="text/javascript" src="sources/dhtmlxMenu/codebase/dhtmlxcommon.js"></script> -->

<!-- toolbar -->
<!--<script type="text/javascript" src="sources/dhtmlxToolbar/codebase/dhtmlxcommon.js"></script>-->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>

<!-- combo -->
<!--<link rel="stylesheet" type="text/css" href="sources/dhtmlxCombo/codebase/dhtmlxcombo.css"/>-->
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxCombo/codebase/dhtmlxcombo.js"></script>

<!-- grid -->
   <!-- <script src="sources/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>-->
    <script src="<%=jsResourcePath%>dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
    <!-- <script src="sources/dhtmlxGrid/codebase/ext/dhtmlxgrid_pgn.js"></script> -->
    <script src="<%=jsResourcePath%>dhtmlxGrid/codebase/ext/dhtmlxgrid_srnd.js"></script>
    <script src="<%=jsResourcePath%>dhtmlxGrid/codebase/excells/dhtmlxgrid_excell_grid.js"></script>

<!-- dataProcessor -->
<script src="<%=jsResourcePath%>dhtmlxCommon/codebase/dhtmlxdataprocessor.js"></script>
<script type="text/javascript" src="<%=jsResourcePath%>dhtmlxGrid/codebase/ext/dhtmlxgrid_start.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/WPCImageState.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/WpcCommonJs.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/WpcjsRoleManagerJs.js"></script>

<script type="text/javascript">
$(function(){
	//alert('JQuery found!');
	//alert('called');
})
</script>

<div id="parentId" >

	<div id="button-bar">
	<div id="images-div">
		<button type="button" id="topPreviewButton" class="Button">Preview</button></div>
		<div class="row" id="imageButton">
			<h2 id="imageButton" style="float:left" class="row">Images</h2>
			<button id="imageButton" type="button" class="expButton">Expand</button>
			<div id="imagesStatus" class="toolbarStatus">Loading...</div>
		</div>
		
		<div id="image_toolbar1" class="toolbar" style="clear:both"></div>
		<div id="image_toolbar2" class="toolbar"></div>
		<div id="image_toolbar2b" class="toolbar"></div>
		<div id="image_container" class="item_container"></div>
	</div>
	<div id="logos-div">
		<div class="row" id="logoButton" >
			<h2 style="float:left" class="row">Logos</h2>
			<button id="logoButton" type="button" class="expButton">Expand</button>
			<div id="logosStatus" class="toolbarStatus">Loading...</div>
		</div>
		
		<div id="logo_toolbar" class="toolbar" style="clear:both"></div>
		<div id="logo_container" class="item_container"></div>
	</div>
	<div id="copy-div">
		<div class="row" id="copyButton">
			<h2 style="float:left" class="row">Copy</h2>
		</div>
		
		<div id="copy_toolbar" class="toolbar" style="clear:both"></div>
		<!-- This is the grid container -->			
		<div id="copy_container" class="item_container"></div>
	</div>
	<button type="button" id="previewButton" class="Button">Preview</button>
</div>
<div class="overlay" id="overlay">
</div>
<div id="overlay-over-data-entry">
	<div id="overlay-buttons">
		<button type="button" id="cancelEdit" class="overlay-button">Cancel</button>
		<button type="button" id="saveEdit" class="overlay-button">Save Copy</button>
		<div id="copyLevelSelect" class="combo"></div><label id='cascade-txt'></label>
	</div>
	<div id="copy-edit-grid"></div>
</div>
<div id="overlay-over-repro-popup">

	Target Repro House: <select id="overlay-over-repro-place">
	</select>
	<div id="overlay-over-repro-checkboxes">
	<div id="overlay-over-repro-checkbox-header">Repro action types</div>
	</div>
	<div id="overlay-over-repro-buttons">
	<input type='button' value='Cancel' id='overlay-over-repro-button-cancel'>
	<input type='button' value='Save' id='overlay-over-repro-button-save'>
	</div>
	<div id='overlay-over-repro-folder-name-div' >Documentum Package Tag:<input type='text' size='40' maxlength='40' disabled='disabled' id='overlay-over-repro-folder-name'></div>
	<div id="overlay-over-repro-images"></div>
</div>

<div id="overlay-over-comment">
	<div>
		<button type="button" id="cancelCommentEdit" style="float: left">Cancel</button>
		<button type="button" id="saveCommentEdit" style="float: left">Save</button>
		<div id="comment-char-count" style="float: left; margin-left:20px; margin-top:5px;"> </div>
		<button type="button" style="float: right" id="clearCommentEdit">Clear</button>
	</div>
	<div id="comment-edit-div">
		<textarea id="comment-edit-textarea" rows="5" cols="50"></textarea>
	</div>
	<div id="comment-edit-error"></div>
</div>
<div id="overlay-over-message">
	<h1>Loading...</h1>
	<div id="overlay-over-text"></div>
	<div id="overlay-over-buttons"><button type="button" id="closeMessagePopup">Close</button></div>
</div>
<div id="overlay-over-croppings">
	<div>Loading...</div>
</div>
<div id="preview-panel">
	<div id="preview-hero-holder">
		<div id="preview-hero-view">
		</div>
		<div id="hero-scroller"><div id="hero-scroller-inner"></div></div>
	</div>
	<div id="preview-title"></div>
	<div id="preview-text-hold">
	<div id="preview-text-tab">Product Details</div>
	<div id="preview-text-tab-underline"></div>
	<div id="preview-text-view"></div>
	</div>
	<div id="preview-colour-selector">
		<select>
			<option>Select</option>
			<option>RED</option>
		</select>
	</div>
	<div id="preview-image-box"></div>
	<button type="button" id="closePreviewButton">Close</button>
</div>

<%--
${errorMessage}
<form action="/login.do" method="post">
Enter your name and password <input type="text" name="name"> <input type="text" name="password">
<input type="submit"> 
</form>
 --%>
 
 <script type="text/javascript">
  //$( "#logoButton" ).css( "border", "3px solid red" );
 //$("#preview-image-box").hide());
 var image_data;
 var channelcode = "";
 var lifestylecode = "";
 var seasoncode = "";
 var localecode = "";
 
 $(function(){//alert('CALLED');
// declareDHTMLItems();
	 var oldsaveAssetMakerContentForm=saveAssetMakerContentForm;
 
	var saveAssetMakerContentForm=function() {
			alert('saveAssetMakerContentForm found!');
			var crpped = stateManager.findUntaggedWithUpdatedTag(TAG.CROP_REQUESTED);
			var reproed = stateManager.findUntaggedWithUpdatedTag(TAG.REPRO_REQUESTED);
			var msg = "";
			if (crpped.length || reproed.length) {
				msg = "some images have been marked \n"+
				((crpped.length && reproed.length)?"Some images Cropped and Reproed" : 
				 (crpped.length)?"Crop Requested\n" : "Repro Requested\n")+
				 " but they are not tagged so the actions will not be performed \n\n"+
				 " Do you wish to continue with the Save or Cancel and return to the Web Proof Check Editor?";
			if (confirm(msg)) {
				for (var i=0; i <crppd.length; i++) {
					stateManager.tagChange(crpped[i].pidId, TAG.NO_CROP);
				}
				for (var i=0; i <reproed.length; i++) {
					stateManager.tagChange(reproed[i].pidId, TAG.NO_REPRO);
				}
				stateManager.writeTagStateToOutputImages();
				return oldAssetMakerContentForm();
				} else return false;
			} else {
				stateManager.writeTagStateToOutputImages();
				return oldAssetMakerContentForm();
				}
		};	
 	});		
		
		var isMSIE=/*@cc_on1@*/0;
		if (isMSIE){
			var img_width=82;
			var img_height=142;
			var logo_width=82;
			var logo_height=90;
			var icon_pos_frig=20;
		}else{
			var img_width=62;
			var img_height=122;
			var logo_width=62;
			var logo_height=70;
			var icon_pos_frig=0;
		}	
			
		var dhtmlxMouseEventCopy = dhtmlx.MouseEvents._onClick;
		dhtmlx.MouseEvents._onClick = function(a) {
			if (!a.ctrlKey && a.metaKey) {
				var b = document.createEvent('MouseEvents');
				b.initMouseEvents('click', a.bubbles, a.cancelable,
						document.defaultView, a.detail, a.screenX, a.screenY,
						a.clientX, a.clientY, trye, a.altKey, a,shfitKey, a.metaKey,
						a.button, null);
				a.target.dispatchEvent(b);
			}else{
				dhtmlxMouseEventCopy.call(this, a);
			}
		};
		
		function initialiseFieldDefinitions() {
			
			CONTAINER = {
				LOGO:{name: "logo_container", toolbars:["logo_toolbar"], size: 100},
				IMAGE:{name: "image_container", toolbars:["image_toolbar1", "image_toolbar2", "image_toolbar2b"], size: 100},
				COPY:{name: "copy_container", toolbars:["copy_container"], size: function(){return $("copy_container table").outerHeight();}}
			};
			
			/*Function for the positioning of tags */
			TAG = {
					HERO:{
						name:"Hero",
						displayText:"Hero",
						images:'images/wpc-tags/Hero.png',
						code:"1",
						html:"<img src='images/wpc-tags/Hero.png' alt='H' title='Hero'"
					},
					HERO2:{
						name:"Hero2",
						displayText:"Hero2",
						code:"2",
						html:"<span title='Hero2'><span class='tag-o tag=h2-a'>H"+
						"</span><span class='tag-o tag=h2-b'>2</span></span>"
					},
					CROP_REQUESTED:{
						name: "Croprequested",
						displayText: "Crop Peending",
						code: null,
						dim: false,
						borderImage: "#FF0000",
						html: "<img src='images/wpc-tags/Crop.png' alt'CRp' "+
								"title='Crop pending'/>"
						
					},
					NO_CROP:{
						name: "NoCrop",
						displayText: "NoCrop",
						code: null, 
						borderImage: "OFF-#FF000", 
						html: null
						
					},
					NO_REPRO:{
						name: "NoRepro",
						displayText: "No Repro",
						code: null, 
						borderImage: "OFF-#44FF88", 
						html: null
						
					},
					REPRO_REQUESTED:{
						name: "ReproRequested",
						displayText: "Repro Requested",
						code: null, 
						cannotBeReproed: "Cannot repro, another repro in progress",
						borderImage: "#44FF88",
						html: function(id) {
						 if (id) {
								var txt = stateManager.getReproComment(id);
								var ot = stateManager.getOrigTagOfType(id, TAG.REPRO_REQUESTED);
								var edCom = (!ot || ot.name != TAG.REPROREQUESTED.name) &&
									is("wpc.repro.allow.comments");
							}
						 if (txt) {
								txt = !txt?"":txt;
								txt = txt.replace(/'/g, "&#039;").replace(/"/g, "&quot;");
								var ret = "<img src = 'images/wpc-tags/Repro.png' ";
								if (edCom) ret += "onclick=\"editComment('"+id+"', 'reproComment', 400)\" ";
								ret += "alt='R' title=Repro Requested, Comment:\n"+txt+"'/>";
								return ret;
							 }else{
								var ret = "<img src = 'images/wpc-tags/Repro.png' ";
								if (edCom) ret += "onClick=\editComment('"+id+"', 'reproComment', 400)\" ";
								ret += "alt = 'R' title='Repro Requested' />";
								return ret;
							 }
						}
					},
					REPRO_HISTORY:{
						name: "ReproHistory",
						displayText : "Has been Reproed",
						code: null,
						borderImage: "#OFF-44FF88",
						html: function(id) {
							var txt="";
							var edCom=null;
							if (id) {
								var txt = stateManager.getReproComment(id);
								var ot = stateManager.gerOrigTagOfType(id, TAG,REPRO_RQEUESTED);
								var edCom = (!ot || TAG.REPRO_RQEUESTED,name) && 
									is("wpc.repro.allowcomments");
							}
							if (txt) {
								txt=!txt?"":txt;
								txt = txt.replace(/'/g, "#039;").replace(/"/g, "&quot;");
								var ret = "<img src='images/wpg-tags/Repro_History.gif'";
								 if(edCom) ret+= "onclick=\"editComment('"+id+"', 'reproComment', 400)\" ";
								 ret += "alt='R' title='Repro History, Comment:\n"+txt+"\>''";
								 return ret;
							}else{
								var ret = "<img src='images/wpg-tags/Repro_History.gif'";
								if(edCom) ret+= "onclick=\"editComment('"+id+"', 'reproComment', 400)\" ";
								ret +="alt='R' title='Repro History' />";
								return ret;
							}
						}
					},
					NO_REPRO:{
						name:"NoRepro",
						displayText: "No Repro",
						code: null,
						borderImage: "#OFF-44FF88",
						html: ""
					}
				};
				
				/* Start of loader Object - encapsulates all required loading functions...*/
		var loader = new function() {
			var self = this;
			this.preLoadContainers = function(){
				image_data.clearAll();
				//$("#image_container").bind("DOMSubTreeModified", redrawHandler.tagRedrawSoon());
				//DomTreeSubModified does not work on IE so the two lines below make it work a bit
				if (isMSIE){
					$(window).resize(redrawHandler.tagRedrawSoon);
					image_data.attachEvent(redrawHandler.tagRedrawSoon);
				}
				initialLoadImagesFromAjax(localecode);
				logo_data.clearAll();
			}
		};
		
			/* IT ALL STARTS HERE!!!! */
		$(function() {
			
			channelcode = 'WEB';
			lifestylecode = 'simplybe';
			seasoncode = 'AW2008';
			localecode = 'en_GB';
			$("#logoButton").click(function(){areaSelector.resizeButton(CONTAINER_LOGO);});
			initialiseFieldDefinitions()
			declareDHTMLItems();
			
			loader.preLoadContainers();
		});
		
		/* areaSelector */
		var areaSelector = new function(){
			/* This is intended to be called when the top bar 
			of a DHTML container is clicked. selectedArea keeps track of 
			which was clicked
			
			x must be a n entry from the CONTAINER table or null
			*/
			var selectedArea = null;
			this.resizeButton = function(){
				var totalSize=0;
				for(i in CONTAINER){
					var con = CONTAINER[i];
					var sz = (typeof con.size == "function")?con.size():con.size;
					$("#"+con.name).height(sz);
					totalSize+=sz;
				for(var t in con.toolbars){
					$("#"+con.toolbars[t]).show();	
				}
			  }
				//TO DO selectedArea etc.
			}
		};
		
		/* Manage popups */
		var popupManager = new function() {
			var self = this;
			var overlay_over_data_entry_min_height=0;
			var overlay_over_data_entry_min_width=0;
			var popupShouldHaveClosed=true;
			var dataEntryCommentId=null;
			
			var activePanels = {};
						
			//close  a popup
			//disconnect/resize etc if there are no popups there
			var closePopup = function(name) {
				if (activePanels[name])
					$("#"+activePanels[name]).hide();
					delete activePanels[name];
					var numberActive = 0;
					for (var i in activePanels) numberActive+=1;
					if (numberActive==0){
						$("#overlay").hide();
						$(window).unbind("resize", processOnResize);
						$(window).unbind("scroll", processOnResize);
					}
					popupShouldHaveClosed=true;
				};
				
			//openpopup by name
			var openPopup = function(name){
				if(activePanels[name]) closePopup(name);
				var numberActive = 0;
				for (var i in activePanels) numberActive+=1;
				activePanels[name] = name;
				$("#overlay, #"+activePanels[name]).show();
				processOnResize();
				$(window).unbind("resize", processOnResize);
				$(window).unbind("scroll", processOnResize);
			}
		
		//repositions popup in the middle following process or resize
		var setOverlayPosition = function(){
			var l = $(document).scrollLeft();
			var t = $(document).scrollTop();
			var w = $(window).width();
			var h = $(window).height();
			$("#overlay").css({
				top: t="px",				
				left: l="px",				
				width: w="px",				
				height: h="px",
				zIndex: 100
			});
		};
		
		//called on screen resize or scroll
		//repositions the popup in the middle
		var processOnResize = function(){
			var first = true;
			var l = $(document).scrollLeft();
			var t = $(document).scrollTop();
			var w = $(window).width();
			var h = $(window).height();
			for(activePanel in activePanels){
				if(first)setOverlayPosition();else first=false;
				var e = $("#"+activePanels);
					var eh = e.outerHeight();
					var ew = e.outerWidth();
					var top = Math.floor((h-eh)/2+t);
					var top = Math.floor((h-ew)/2+1);
					var o = e.offSet();
					if(eh>h){
						var wt=t;
						var wb=t+h;
						var et=o.top;
						var eb=o.top+eh;
						if(et>wt+10) top=wt+10;
						else if (et<wb-10) top=wb-eh-10;
						else top=et;
					}
					var toppx=top+"px";
					var leftpx=left+"px";
					e.css({
						top: toppx,
						left: leftpx,
						zIndex: 200
					});
				}
			};
			
			this.closeMessagePopup= function(){
				closePopup("overlay-over-message");
			};
			
						this.openMessagePopup= function(mess){
				$("#overlay-over-buttons").hide();
				$("#overlay-over-text").html("");
				$("#overlay-over-message h1").html(mess?mess:"Loading..");
				
				openPopup("overlay-over-message");
			};
		 }
		 
			/* Initital population of selected images */
			var initialLoadImagesFromAjax = function(localetouse) {
				//popupManager.openMessagePopup("Loading images from Documentum");
				var url = "";
				if(lifestylecode.length>0) url+"&lifestyle="+lifestylecode;
				if(seasoncode.length>0) url+"&season="+seasoncode;
				if(localetouse.length>0) url+"&localecode="+localetouse;
				
				$.ajax({
					url: url, 
					dataType: "json",
					success: function(data){initialLoadOfCurrSeasonImagesCall(data, 
							localetolouse);},
					
					error: function(x, y, msg){
						popupManager.closeMessagePopup();
						alert("Initial Image load failed. Failed to connect to server: "+msg);
					}
				});
			};
	//};
		//creates DHTMLX items incl. DataViews
		function declareDHTMLItems() {
			
			copyLevelSelect = new dhtmlXCombo("copyLevelSelect", "copyLevelSelect", 150);
			initCombo(copyLevelSelect);
			boxType("copyLevelSelect");
			
			$.ajax({
				
					url: "/in28Minutes-first-webapp/getImages?"+
					"function=IMG_ALL"+
					  "&style=json"+
					  "&channel=WEB",
					dataType: false,
					success: function () {
						alert('SUCCESS');
					
					},
					error: function (a, err) {alert('FAIL');}
				});
				copyLevelSelect.attachEvent("onChange", function (){
				copyHandler.editCopyNewLevel('TYPE_CHANGE');
			});
					image_data = new dhtmlXDataView({
				container: "image_container",
				type: {
					template: 
					"<div id='pic-#id' onclick=redrawHandler.tagRedrawSoon()>"+ 
						"<div target='blank' "+
						"onmouseover='onLinkHover(&#39;#hoverImageSource&#39;,"+
						"#&39#pic-id#&#39;,"+
							"<table><tr><td>Name:</td><td>#filename#</td></tr>"+
							"<table><tr><td>Lifestyle:</td><td>{ls:#lifestyle}</td></tr>"+
							"<table><tr><td>Season:</td><td>#filename#</td></tr>"+
							"<table><tr><td>Locale:</td><td>{lc:#locale#}</td></tr>"+
							"<table><tr><td>Colour:</td><td>#colour#</td></tr>"+
							"<table><tr><td>Channel:</td><td>#channel#</td></tr>"+
						"onmouseout='onLinkNotHover()''"+
						"<div class='image-body'>"+
							"<img class='wpc_image' src='#' alt='Image not available.' />"+
						"</div>"+
						"<div class='image-filename'>#filename#</div>"+
						"</div>"+
					"</div>",
						width: img_width,
						height: img_height
				}
			});
			logo_data = new dhtmlXDataView({
				container: "logo_container",
				type: {
					template: 
					"", 
					width: img_width,
					height: img_height
				}
			});
			image_toolbar = new dhtmlxToolbarObject("image_toolbar"); 
			image_toolbar2 = new dhtmlToolbarObject("image_toolbar2");
			image_toolbar2b = new dhtmlxToolbarObject("image_toolbar2b");
			loadToolbarObjects(image_toolbar2, IMAGE_BUTTONS, A, 0);
			loadToolbarObjects(image_toolbar2b, IMAGE_BUTTONS, B, 0);
			loadMenuFields(CONTAINER.IMAGE, image_data);
			
			image_toolbar.addText("image_toolbar_title_text", 0, "");
			loadToolbarFields(image_toolbar, IMAGE_2_BUTTONS, 1);
			
			logo_toolbar = new dhtmlxToolbarObject("logo_toolbar");
			loadToolbarFields(logo_toolbar, LOGO_BUTTONS, 0);
			loadMenuFields(CONTAINER.LOGO, logoData);
			
			copy_toobar = new dhtxmlToolbarObject("copy_toolbar");
			loadToolbarFields(copy_toolbar, COPY_BUTTONS, 0);
		}
		function loadMenuFields(container, dhxContainer){
			var cont = container.name;
			var menuBtns = contianer.menu;
			var activeId = null;
			if (menuBtns){
				$("body").append("\
				<div id='"+cont+"_menu' class='menu_holder'>\
				</div>\
				");
				
			$("#"+cont).delegate(".dhx_dataview_item", "contextmenu", function(e){
				var m = $("#"+cont+"_menu");
				m.css({
					top: epageY-3,
					left: epageX-3
				}).show();
				var width = m.outerWidth();
				var height = m.outerHeight();
				var swidth=$(window).width(); 
				var sheight=$(window).height();
				var sr = swidth+$(window).scrollLeft();
				var sb = sheight+$(window).scrollTop();
				var r = e.pageX-3+width;
				var b = e.pageY-3+height;
				if(sr<r || sb<b)m.css({
						top: e.pageY-3-(sb<b?b-sb-1:0),
						left: e.pageX-3-(sr<r?r-sr-1:0)
					});
					activeId = $(this).attr("dhx_f_id");
					return false;
				});
			$("#"+cont+"_menu").bind("mouseleave", function() {
				$("#"+cont+"_menu").hide();
			});
			for(var i in menuBtns) {
				var l = menuBtns[i];
				if (l.button && typeof l.func ==="function"){
					var ok = true;
					if(l.control){
						if (typeof l.control === "function"){
							ok = l.control();
						} else if (typeof l.contorl === "string"){
							var v = l.control;
							if(v) v = $.trim(v);
							if (!v || v === "true" || v === "null"){
								ok = true;
							} else if (v +++ "false") {
								ok = false;
							} else {
								ok = getRoleManager().hasAnyColourRole(v);
							}
						}
					}
				}
			}
			if(ok){
				$("#"+cont+"_menu").append(
						"<div class='menu-entry' id='"+cont+"_menu_"+i+"'>"+
						(l.button.image?"<img src='"+l.button.image+"'> ":"")+
						l.button.displayText+
						"</div>");
				(function(){
					var ll = l;
					
					$("#"+cont+"_menu_"+i).bind("click", function(){
						if(!ll.select || ll.select == SELECT.MODE.REQUIRED	)
							if(!dhxContainer.isSelected(activeId))
								dhxContainer.select(activeId);
							ll.func();
						});
					})();
					$("#"+cont+"_menu_"+i).bind("mouseover", function(){
						$(".menu-entry").removeClass("over");
						$(this).addClass("over");
					});
					$("#"+cont+"_menu_"+i).bind("mouseout", function(){
						$(".menu-entry").removeClass("over");
					});
				}
			 }
		   }
		}
		var copyHandler = new function(){
			var self = this;
			var packFilter = function(channel, lifestyle, season, lifestyle, locale) {
				return channel+"__"+lifestyle+"__"+season+"__"+locale;
			};
			//scores for different copy types
			//vla is a ratign +ve is a signal of importance and overrides copy of less +ve
			//filter is to be provided to hte copy editor, so it knows the status we are working at
			var score = {
					LOCALE:{
						name: "LOCALE", 
						val: 12, 
						filter: packFilter("WEB", '', '', localecode)
					},
					LIFE_STYLE:{
						name: "LIFE_STYLE", 
						val: 10, 
						filter: packFilter("WEB", lifestylecode, '', "en_GB" )
					},
					SEASON:{
						name: "SEASON", 
						val: 8, 
						filter: packFilter("WEB", '', seasoncode, "en_GB" )
					}, 
					WEB:{
						name: "WEB", 
						val: 6, 
						filter: packFilter("WEB", '', '', "en_GB" )
					},
					CAT:{
						name: "Cat Copy", 
						val: 0, 
						filter: null
					},
					TRADESTONE:{
						name: "Merch Copy", 
						val: -1, 
						filter: null
					},
					NONE:{
						name: "NONE", 
						val: -2, 
						filter: null
					}
				};
				var bestScore = function(){
					var curScore = score.NONE;
					for (var i in copyData){ //Where's copyData instanced?
						var ctt = copyData[i].type.toLowerCase();
						var newScore;
						if(/^.*locale.*$/.test(cct)) newScore = score.LOCALE;
						if(/^.*lifestyle.*$/.test(cct)) newScore = score.LIFE_STYLE;
						if(/^.*season.*$/.test(cct)) newScore = score.SEASON;
						if(/^.*web.*$/.test(cct)) newScore = score.WEB;
						if(/^.*cat.*$/.test(cct)) newScore = score.CAT;
						if(/^.*(trade|merch).*$/.test(cct)) newScore = score.TRADESTONE;
						else newScore = score.NONE;
						if (newScore.val > curScore.val) curScore = newScore;
					}
					return curScore;
				};
				var DEF_FILTER = packFilter("WEB", '', '', "en_GB");
				var selectedCopyType = null;
				var selectedCopyTypeX = false;
		};
				
		this.editCopyNewLevel = function (newWeb) {
			if(selectedCopytypeX) return;
			selectedCopytypeX=true;
			
			if (newWeb=='TYPE_CHANGE' && $('#web-edit-iframe').length>0) {
				var dproc=$('#web-edit-iframe')[0].contentWindow.copyDataProcessor;
				
				if(!dproc.getSynchState()) {
					if(confirm('Setting the text level without saving\n'+
								'will lose any changes you have made\n'+
								'Do you wish to continue and lose your changes?')){
						
						selectedCopyTypeX=false;
						return true;
					}
				}
			}
		};
	//})
</script>
</body>
</html>