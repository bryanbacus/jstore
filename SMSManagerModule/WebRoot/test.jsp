<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Subrow excell</title>
<style> .even{background-color:#E6E6FA;}.uneven{background-color:#F0F8FF;}</style>
<link rel="STYLESHEET" type="text/css" href="js/dhtmlx/codebase/dhtmlxgrid.css">
<link rel="STYLESHEET" type="text/css" href="js/dhtmlx/codebase/dhtmlxgrid_skins.css">
<script src="js/dhtmlx/codebase/dhtmlxcommon.js"></script>
<script src="js/dhtmlx/codebase/dhtmlxgrid.js"></script>
<script src="js/dhtmlx/codebase/dhtmlxgridcell.js"></script>
</head>
<body>
Test....DHTMLX

<div id="gridbox" width="100%" height="250px" 
	style="background-color:white;overflow:hidden"></div>
<script> 
        mygrid = new dhtmlXGridObject('gridbox');
        mygrid.setImagePath("js/dhtmlx/codebase/imgs/");
        mygrid.loadXML("gridH.xml");
</script>


</body>
</html>