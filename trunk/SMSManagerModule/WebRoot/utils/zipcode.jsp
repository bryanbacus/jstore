<%@ page contentType="text/html; charset=big5" %>
<%@ page language="java"%>

<table style="width:100%;height:100%; text-align: center;">
<tr>
<td><b>�п�ܱz���a�}</b>
<form name="zipForm" method="post">
	<table>
	<tr>
		<td>
			<font color="#666666">�l���ϸ�</font>
			<input name="zipcode" size=5 readonly="readonly" onfocus="alert('�l���ϸ��|�۰ʲ���');zipForm.zipcode.blur(); " style="border:none;">
			<select name="countyText" 
					onChange="changeZone(zipForm.countyText, zipForm.area, zipForm.zipcode, zipForm.address, zipForm.county)" size=1>
			</select>
			<font color="#666666">��/�� </font> &nbsp;
			<select name="area" 
					onChange="showZipCode(zipForm.countyText, zipForm.area, zipForm.zipcode, zipForm.address, zipForm.county)" size=1>
			</select>
			<font color="#666666">�m��ϥ� </font>
		</td>
	</tr>
	<tr>
		<td>
			<font color="#666666">�a�}: </font>
			<input name="other" size=55><br/>
		</td>
	</tr>
	<tr>
		<td align="center">
			<input name="address" size=25  type="hidden">
			<input name="county" size=5 type="hidden">
			<input name="submit" type="button" value="�T�w" onClick='ok2(zipForm.zipcode,zipForm.address)'>
			<input name="close" type="button" value="����" onClick='window.close()' >
		</td>
	</tr>
	<tr><td style="border-style: dotted;border-color: red; color:red;">
	
	�п�ܱz�������P�ϰ�A
	�t�η|�۰ʲ��X�z���l���ϸ��A<br/>
	�ýж�g���z�Ѿl���a�}���q�A����!<br/>
	
	</td></tr>
	</table>
</form>
</td>
</tr>
</table>

<!-- ������ -->

<script language="JavaScript" TYPE="text/javascript">
<!--

//==================== for zip code begin =========================
County = new Array("�O�_��", "�򶩥�", "�O�_��", "�y����", "�s�˥�", 
		"�s�˿�", "��鿤", "�]�߿�", "�O����", "�O����", "���ƿ�",
		"�n�뿤", "�Ÿq��", "�Ÿq��", "���L��", "�O�n��", "�O�n��",
		"������", "������", "���", "�̪F��", "�O�F��", "�Ὤ��",
		"������", "�s����", "�n���Ѯq", "�����x�C��");

Zone = new Array(27);
// for "�O�_��"
Zone[0] = new Array("������","�j�P��","���s��","�Q�s��","�j�w��",
	"�U�ذ�","�H�q��","�h�L��","�_���","�����","�n���",
	"��s��(��])","��s��(����)");
// for "�򶩥�"
Zone[1] = new Array("���R��","�H�q��","������","���s��","�w�ְ�",
	"�x�x��","�C����");
// for "�O�_��"
Zone[2] = new Array("�U���m","���s�m","�O����","������","�`�|�m","����m","�����",
	"���˶m","���˶m","�^�d�m","�s����","�W�L�m","�Q�Ӷm","�éM��","���M��","�g����",
	"�T�l��","��L��","�a�q��","�T����","�s����","���s�m","�L�f�m","Ī�w��","���Ѷm",
	"�K���m","�H����","�T�۶m","�۪��m");
// for "�y����"
Zone[3] = new Array("�y����","�Y����","�G�˶m","����m","���s�m","ù�F��","�T�P�m",
	"�j�P�m","�����m","�V�s�m","Ĭ�D��","�n�D�m");
// for "�s�˥�"
Zone[4] = new Array("");
// for "�s�˿�"
Zone[5] = new Array("�˥_��","��f�m","�s�׶m","�s�H�m","������","�|�L�m","�_�s�m",
	"�˪F��","���p�m","��s�m","�y�۶m","�_�H�m","�o�ݶm");
// for "��鿤"
Zone[6] = new Array("���c��","����","�s��m","������","�s�ζm","�[���m","��饫",
	"�t�s�m","�K�w��","�j����","�_���m","�j��m","Ī�˶m");
// for "�]�߿�"
Zone[7] = new Array("�˫n��","�Y����","�T�W�m","�n�ܶm","���m","���s��","�q�]��",
	"�b����","�]�ߥ�","�y���m","�Y�ζm","���]�m","�j��m","���w�m","���r�m","�T�q�m",
	"���m","�����m");
// for "�O����"
Zone[8] = new Array("����","�F��","�n��","���","�_��","�_�ٰ�",
	"��ٰ�","�n�ٰ�");
// for "�O����"
Zone[9] = new Array("�ӥ���","�j����","���p�m","�Q��m","�׭쥫","�Z���m","�۩��m",
	"�F����","�M���m","�s���m","��l�m","�j���m","�����m","�j�{�m","�F����","�s���m",
	"�����","�M����","�j����","�~�H�m","�j�w�m");
// for "���ƿ�"
Zone[10] = new Array("���ƥ�","���m","��¶m","�q���m","������","�ֿ��m","�u��m",
	"�M����","����m","���L��","���Y�m","�ùt�m","�H�߶m","�˴���","�j���m","�H�Q�m",
	"�Ф���","�_����","�Ч��m","���Y�m","�˦{�m","�˶�m","�G�L��","�j���m","�ڭb�m",
	"�G���m");
// for "�n�뿤"
Zone[11] = new Array("�n�륫","���d�m","�����","��m�m","�H����","���R�m","�W���m",
	"�����m","�����m","�����m","�H�q�m","�ˤs��","�����m");
// for "�Ÿq��"
Zone[12] = new Array("");
// for "�Ÿq��"
Zone[13] = new Array("�f���m","���s�m","�˱T�m","�����s�m","���H�m","�j�H�m",
"���W�m","����m","�ӫO��","���l��","�F�۶m","���}�m","�s��m","�����m","�j�L��","�~�f�m",
"�q�˶m","���U��");
// for "���L��"
Zone[14] = new Array("��n��","�j��m","�����","�g�w��","�ǩ��m","�F�նm","�O��m",
	"�[�I�m","���d�m","�椻��","�L���m","�j�|�m","�l��m","������","�G�[�m","�_����",
	"���L�m","�f��m","�|��m","�����m");
// for "�O�n��"
Zone[15] = new Array("����","�F��","�n��","���","�_��","�w����",
	"�w�n��");
// for "�O�n��"
Zone[16] = new Array("�ñd��","�k���m","�s����","����m","�ɤ��m","����m","�n�ƶm",
	"���w�m","���q�m","�s�T�m","�x�жm","�¨���","�Ψ���","���m","�C�Ѷm","�N�x�m",
	"�ǥ���","�_���m","�s�祫","����m","�ժe��","�F�s�m","���Ҷm","�U��m","�h��m",
	"�Q����","������","�j���m","�s�W�m","�s���m","�w�w�m");
// for "������"
Zone[17] = new Array("�s����","�e����","�d����","�Q�L��","���s��",
	"�X�z��","�e���","�T����","�����","�p���","�����");
// for "������"
Zone[18] = new Array("���Z�m","�j���m","���s��","���˶m","�����m","�мd�m","�P�_�m",
	"���Y�m","��x�m","�����m","�æw�m","�򤺶m","��s��","�j�d�m","�L��m","���Q�m",
	"�j��m","�X�s��","���@��","���t�m","�����m","���L�m","�ҥP�m","�緽�m","�T���m",
	"�Z�L�m","�X�_�m");
// for "���"
Zone[19] = new Array("������","�����m","��w�m","�C���m","�ըF�m","���m");
// for "�̪F��"
Zone[20] = new Array("�̪F��","�T�a���m","���O�m","���a�m","�E�p�m","����m","����m",
	"�Q�H�m","���v�m","�ﬥ�m","�˥жm","���H�m","�U���m","��{��","���Z�m","�Ӹq�m",
	"�U�r�m","�O���m","�s��m","�n�{�m","�L��m","�F����","�[�y�m","�ΥV�m","�s��m",
	"�D�d�m", "�D�s�m","�K��m","��l�m","�����m","�d���m","��K��","���{�m");
// for "�O�F��"
Zone[21] = new Array("�O�F��","��q�m","�����m","�����m","���n�m","�����m","���s��",
	"���ݶm","���W�m","�F�e�m","���\��","���ضm","�ӳ¨��m","���p�m","�j�Z�m","�F���m");
// for "�Ὤ��"
Zone[22] = new Array("�Ὤ��","�s���m","�q�L�m","�N�w�m","���׶m","��L��","���_�m",
	"���ضm","���J�m","�U�a�m","�ɨ���","���˶m","�I���m");
// for "������"
Zone[23] = new Array("���F��","������","����m","������","�P���m","�Q���m");
// for "�s����"
Zone[24] = new Array("�n��m","�_��m","�����m","�F��");
// for "�n���Ѯq"
Zone[25] = new Array("�F�F","��F");
// for "�����x�C��"
Zone[26] = new Array("");

ZipCode = new Array(27);
// for "�O�_��"
ZipCode[0] = new Array("100","103","104","105","106","108","110","111",
	"112","114","115","116","117");
// for "�򶩥�"
ZipCode[1] = new Array("200","201","202","203","204","205","206");
// for "�O�_��"
ZipCode[2] = new Array("207","208","220","221","222","223","224","226",
	"227","228","231","232","233","234","235","236","237","238","239",
	"241","242","243","244","247","248","249","251","252","253");
// for "�y����"
ZipCode[3] = new Array("260","261","262","263","264","265","266","267",
	"268","269","270","272");
// for "�s�˥�"
ZipCode[4] = new Array("300");
// for "�s�˿�"
ZipCode[5] = new Array("302","303","304","305","306","307","308","310",
	"311","312","313","314","315");
// for "��鿤"
ZipCode[6] = new Array("320","324","325","326","327","328","330","333",
	"334","335","336","337","338");
// for "�]�߿�"
ZipCode[7] = new Array("350","351","352","353","354","356","357",
	"358","360","361","362","363","364","365","366","367","368","369");
// for "�O����"
ZipCode[8] = new Array("400","401","402","403","404","406","407","408");
// for "�O����"
ZipCode[9] = new Array("411","412","413","414","420","421","422","423",
	"424","426","427","428","429","432","433","434","435","436","437",
	"438","439");
// for "���ƿ�"
ZipCode[10] = new Array("500","502","503","504","505","506","507","508",
	"509","510","511","5112","513","514","515","516","520","521","522",
	"523","524","525","526","527","528","530");
// for "�n�뿤"
ZipCode[11] = new Array("540","541","542","544","545","546","551","552",
	"553","555","556","557","558");
// for "�Ÿq��"
ZipCode[12] = new Array("600");
// for "�Ÿq��"
ZipCode[13] = new Array("602","603","604","605","606","607","608","611",
	"612","613","614","615","616","621","622","623","624","625");
// for "���L��"
ZipCode[14] = new Array("630","631","632","633","634","635","636","637",
	"638","640","643","646","647","648","649","651","652","653","654",
	"655");
// for "�O�n��"
ZipCode[15] = new Array("700","701","702","703","704","708","709");
// for "�O�n��"
ZipCode[16] = new Array("710","711","712","713","714","715","716","717",
	"718","719","720","721","722","723","724","725","726","727","730",
	"731","732","733","734","735","736","737","741","742","743","744",
	"745");
// for "������"
ZipCode[17] = new Array("800","801","802","803","804","805","806","807",
	"811","812","813");
// for "������"
ZipCode[18] = new Array("814","815","820","821","822","823","824","825",
	"826","827","828","829","830","831","832","833","840","842","843",
	"844","845","846","847","848","849","851","852");
// for "���"
ZipCode[19] = new Array("880","881","882","883","884","885");
// for "�̪F��"
ZipCode[20] = new Array("900","901","902","903","904","905","906","907",
	"908","909","911","912","913","920","921","922","923","924","925",
	"926","927","928","929","931","932","940","941","942","943","944",
	"945","946","947");
// for "�O�F��"
ZipCode[21] = new Array("950","951","952","953","954","955","956","957",
	"958","959","961","962","963","964","965","966");
// for "�Ὤ��"
ZipCode[22] = new Array("970","971","972","973","974","975","976","977",
	"978","979","981","982","983");
// for "������"
ZipCode[23] = new Array("890","891","892","893","894","896");
// for "�s����"
ZipCode[24] = new Array("209","210","211","212");
// for "�n���Ѯq"
ZipCode[25] = new Array("817","819","290");
// for "�����x�C��"
ZipCode[26] = new Array("290");


function initCounty(countyInput){
	countyInput.length = County.length;
	for (i = 0; i < County.length; i++) {
		countyInput.options[i].value = County[i];
		countyInput.options[i].text = County[i];
	}
	countyInput.selectedIndex = 0;
}

function initZone(countyInput, zoneInput, post ,address, countyindex){
	changeZone(countyInput, zoneInput, post , address, countyindex);
}



function changeZone(countyInput, zoneInput, post ,address, countyindex) {
	selectedCountyIndex = countyInput.selectedIndex;

	zoneInput.length = Zone[selectedCountyIndex].length;
	for (i = 0; i < Zone[selectedCountyIndex].length; i++) {
		zoneInput.options[i].value = Zone[selectedCountyIndex][i];
		zoneInput.options[i].text = Zone[selectedCountyIndex][i];
		if (zoneInput.options[i].text == "�Q�s��")
			zoneInput.options[i].selected = true;
	}
	//zoneInput.selectedIndex = 0;	
	showZipCode(countyInput, zoneInput, post ,address ,countyindex);
}

function showZipCode(countyInput, zoneInput, post ,address, countyindex) {
	post.value = ZipCode[countyInput.selectedIndex][zoneInput.selectedIndex];
	updateaddress(countyInput, zoneInput, address, countyindex);
}

function updateaddress(countyInput, zoneInput, address, countyindex) {
	address.value = countyInput.options[countyInput.selectedIndex].text + zoneInput.options[zoneInput.selectedIndex].text ;
	countyindex.value = countyInput.selectedIndex+1 ;
}


//==================== for zip code end =========================

	function ok(post)		{	
		window.opener.document.theForm.zipcode.value = post.value;
		alert("�z���l���ϸ��O"+post.value+"  �w�g���z��n�F");
//		window.close();
	}
	
	function ok2(post,address)		{	
		//window.opener.document.forms[0].zipcode.value = post.value;
		//window.opener.document.forms[0].address.value = address.value + window.opener.document.free2.address.value;
		//alert("�z���l���ϸ��O"+post.value+" !");
  		//window.close();
	  	alert("�z���l���ϸ��O"+post.value+"�A�a�}�G"+ address.value);
	  	window.opener.document.vipAccountForm.address.value = post.value + address.value + zipForm.other.value;
	  	window.close();
	}
	
	function ResetAll()		{
		initCounty(document.zipForm.countyText);
		initZone(document.zipForm.countyText, document.zipForm.area, document.zipForm.zipcode, document.zipForm.address, document.zipForm.county);
	}

	ResetAll();

// -->

</script>