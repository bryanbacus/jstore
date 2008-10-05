<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <title>javascript</title>
  <META content="text/html; charset=utf-8" http-equiv=Content-Type />

</head>
<body  leftmargin="0" topmargin="0"> 
<font><h3 align="center">RSS News of Rotary International</h3></font>
<br>  
<table width="90%" align="center" border="0" cellpadding=0 cellspacing=0>
  <tr>
   <td bgcolor=White><b>News Center</b><font size="-1">(From http://www.rotary.org/rss.xml)</font><hr></td>
  </tr>
  <tr>
   <td  bgcolor=White>
    <div id="container" >News Loading...</div>
   </td>
  </tr>
</table>
<script language="JavaScript1.2">
//Container for ticker. Modify its STYLE attribute to customize style:
var tickercontainer=''
var xmlsource="http://www.rotary.org/rss.xml";
var root;
var title;
var link; 
var items;
var item;
var images;
var image;
var description;
if (window.ActiveXObject)
{
  //document.write("Microsoft.XMLDOM");
  var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
}
else if (document.implementation && document.implementation.createDocument)
{
  //document.write("document.implementation.createDocument");
  var xmlDoc= document.implementation.createDocument("","doc",null);
}
if (typeof xmlDoc!="undefined")
{
  //document.write(tickercontainer)
  xmlDoc.load(xmlsource)
}  
function fetchxml()
{
  if (xmlDoc.readyState==4)
   output()
  else
   setTimeout("fetchxml()",10)
}
function output()
{  
  var temp="";
  root = xmlDoc.getElementsByTagName("channel")[0];
  title =root.getElementsByTagName("title")[0];
  //temp = title.firstChild.nodeValue +"<br>";
  items=root.getElementsByTagName("item");
  for(i=0;i<=items.length-1;i++)
  {
   item=items[i];
   title=item.getElementsByTagName("title")[0]; 
   link=item.getElementsByTagName("link")[0];
   description=item.getElementsByTagName("description")[0];
   temp = temp + "<image width=10 src='http://www.rid3490.org.tw/rotary/attach/ImageFolder/emblem.gif'/><font size=-1><a href=" + link.firstChild.nodeValue+ " target='_bank'>" + title.firstChild.nodeValue +"</a></font><br>";
   //temp = temp +"<font size=-1>" + description.firstChild.nodeValue + "</font><br><br>";
   document.getElementById("container").innerHTML = temp;
  }
}
if (window.ActiveXObject)
  fetchxml()
else if (typeof xmlDoc!="undefined")
  xmlDoc.onload=output
</script>
</body>
</html>

