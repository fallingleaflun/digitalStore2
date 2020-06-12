var buyerAddressObj;
var buyerNameObj;
var buyerTelObj;

window.onload = function() {	// 页面加载之后, 获取页面中的对象
	buyerAddressObj = document.getElementById("buyerAddress");
	buyerNameObj = document.getElementById("buyerName");
	buyerTelObj = document.getElementById("buyerTel");
};

function checkOnSubmit() {			// 验证整个表单
	var buyerAddress = checkbuyerAddress();
	var buyerName = checkbuyerName();
	var buyerTel = checkbuyerTel();
	if(buyerAddress && buyerName && buyerTel){
		document.getElementById("orderForm").submit();
	}else{
	   return "";
	}
}

function checkbuyerAddress() {			// 验证收货地址
	var value =buyerAddressObj.value;
	var msg = "";
	if (!value)
		msg = "收货地址必须填写";	
	buyerAddressMsg.innerHTML = msg;
	buyerAddressObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkbuyerName() {		// 验证收货人
	var value =buyerNameObj.value;
	var msg = "";
	if (!value)
		msg = "收货人必须填写";	
	buyerNameMsg.innerHTML = msg;
	buyerNameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkbuyerTel() {		// 验证联系方式
	var regex =/^1[3,5,8]\d{9}$/;	//以13、15、18开头的手机号
	var value =buyerTelObj.value;
	var msg = "";
	if (!value)
		msg = "联系方式必须填写";
	else if (!regex.test(value))
		msg = "手机号码不合法：";
	buyerTelMsg.innerHTML = msg;
	buyerTelObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}
