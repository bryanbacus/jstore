set PRJ_HOME=D:\09_Workspace\SMS Platform\SMSManagerModule
set RES_HOME=resources
native2ascii -encoding Big5 "%PRJ_HOME%\SmsWebModule\%RES_HOME%\application_zh_TW.properties.big5"  "%PRJ_HOME%\SmsWebModule\%RES_HOME%\application_zh_TW.properties"
copy "%PRJ_HOME%\SmsWebModule\%RES_HOME%\*" "%PRJ_HOME%\WebRoot\WEB-INF\classes\%RES_HOME%\"