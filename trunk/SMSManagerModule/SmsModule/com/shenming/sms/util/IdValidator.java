package com.shenming.sms.util;



public class IdValidator {
	private String identifier = "" ;
	
	public static boolean ConfirmID(String identifier)//txtname
	{
	  long sum,x=0,y=0;
	  String number=identifier+"";
	  String alert = "";
	  //空白欄位就不檢核
	  if(number=="")
	  {
	    alert = "請輸入身分證號";
	    Tool.logDebug("未輸入身分證號!");
	    return false;
	  }
	  
	  if((number!="") && (number.length())!=10)
	  {
		alert = "身分證號為十碼";
		Tool.logDebug("身分證號為十碼!");
	    return false;
	  } 
	    
	  char L1=number.charAt(0); 
	  char D1=number.charAt(1); 
	  char D2=number.charAt(2); 
	  char D3=number.charAt(3); 
	  char D4=number.charAt(4); 
	  char D5=number.charAt(5); 
	  char D6=number.charAt(6); 
	  char D7=number.charAt(7); 
	  char D8=number.charAt(8); 
	  char D9=number.charAt(9); 
	  L1=(L1+"").toUpperCase().charAt(0);
	  
	  if ((L1+"").toUpperCase().charAt(0)<'A' || (L1+"").toUpperCase().charAt(0)>'Z')
	  {
	    alert = "身分證號錯誤!"; 
	    Tool.logDebug("身分證號錯誤!");
	    return false;
	  }     
	  
	  try {
		  	Tool.logDebug("number.substring(1): "+number.substring(1));
			Long.parseLong(number.substring(1));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = "身分證號末九碼非數字!";
			Tool.logDebug("身分證號末九碼非數字!");
			return false;
		}
	    
	  switch(L1)
	  { 
	    case 'A':
	    case 'a': x=1;y=0; break; 
	    case 'B':
	    case 'b': x=1;y=1; break; 
	    case 'C':
	    case 'c': x=1;y=2; break; 
	    case 'D':
	    case 'd': x=1;y=3; break; 
	    case 'E':
	    case 'e': x=1;y=4; break; 
	    case 'F':
	    case 'f': x=1;y=5; break; 
	    case 'G':
	    case 'g': x=1;y=6; break; 
	    case 'H':
	    case 'h': x=1;y=7; break; 
	    case 'I':
	    case 'i': x=3;y=4; break; 
	    case 'J':
	    case 'j': x=1;y=8; break; 
	    case 'K':
	    case 'k': x=1;y=9; break; 
	    case 'L':
	    case 'l': x=2;y=0; break; 
	    case 'M':
	    case 'm': x=2;y=1; break; 
	    case 'N':
	    case 'n': x=2;y=2; break; 
	    case 'O':
	    case 'o': x=3;y=5; break; 
	    case 'P':
	    case 'p': x=2;y=3; break; 
	    case 'Q':
	    case 'q': x=2;y=4; break; 
	    case 'R':
	    case 'r': x=2;y=5; break; 
	    case 'S':
	    case 's': x=2;y=6; break; 
	    case 'T':
	    case 't': x=2;y=7; break; 
	    case 'U':
	    case 'u': x=2;y=8; break; 
	    case 'V':
	    case 'v': x=2;y=9; break; 
	    case 'W':
	    case 'w': x=3;y=2; break; 
	    case 'X':
	    case 'x': x=3;y=0; break; 
	    case 'Y':
	    case 'y': x=3;y=1; break; 
	    case 'Z':
	    case 'z': x=3;y=3; break; 
	  } 
	  
	  sum=(x+y*9+
				Integer.parseInt(D1+"")*8+
				Integer.parseInt(D2+"")*7+
				Integer.parseInt(D3+"")*6+
				Integer.parseInt(D4+"")*5+
				Integer.parseInt(D5+"")*4+
				Integer.parseInt(D6+"")*3+
				Integer.parseInt(D7+"")*2+
				Integer.parseInt(D8+"")*1+
				Integer.parseInt(D9+"")*1); 
	  
	  Tool.logDebug("Sum is: "+sum);
	  sum=sum % 10; 
	  if(sum!=0)
	  {
	    alert = "身分證號邏輯錯誤!";
		Tool.logDebug("身分證號邏輯錯誤!");
		return false;
	  } 
	  
	  Tool.logDebug("身分證號："+identifier+"是正確的!");

	  return true;
	}
	
	public static void main(String args[]){
		IdValidator iv = new IdValidator();
		System.out.println("Is validate: "+iv.ConfirmID("N123456789"));
	}
}

