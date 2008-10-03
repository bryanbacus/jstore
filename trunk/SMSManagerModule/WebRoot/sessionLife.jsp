<%@ page contentType="text/html;charset=Big5" %>
 
<html>
<head>
  <title>CH10 - SessionLife.jsp</title>
</head>
<body>
 
<h2>Session生命週期範例</h2>
 
<%  
  // 如果session是新的，設定session的初值  
  if(session.isNew())  
  {   
    // 設定session若十秒內沒有活動則使Session過期   
    session.setMaxInactiveInterval(30000);  
    
    // 將此Session time out的秒數加入過期時間中   
    session.setAttribute("expire","30");    
    out.println("設定Session若三十秒內沒有活動則使Session過期");  
  }  
  else  
  {
    String str_expire_time =(String)session.getAttribute("expire");        
    
    // 取得session建構的時間        
    long create_time  = session.getCreationTime();      
    long access_time  = session.getLastAccessedTime();      
    long current_time = System.currentTimeMillis();    
    
    long exist_time   = (current_time-create_time)/1000;    
    out.println("session已存在"+exist_time+"秒");    
    
    // 如果session存在的時間超過30秒，則將session移除    
    if (exist_time >= 30)     
    {      
      out.println("session 時間已到...自動失效");        
      session.invalidate();
     }  
  }
%>
 
</body>
</html>

