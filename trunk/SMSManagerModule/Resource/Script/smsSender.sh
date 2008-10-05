#!/bin/bash
#Usage: sms [SMS TAG] [Phone Number] [SMS Message]
#simonsu@www:~/bin> sms 00003 0912584257 "Love You! Baby! :D"
#Result:
#msgid=1208450613
#statuscode=0
#statusstr=ParseOK
lynx -dump 'http://61.30.48.133:18994/send.cgi?username=VCST001700&password=8695266846&rateplan=A&srcaddr=8708189'$1'&dstaddr='$2'&encoding=BIG5&smbody='"$3"
