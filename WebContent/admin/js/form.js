var nameObj;
var priceObj;
var remainObj;
var categoryObj;
var descriptionObj;

window.onload = function() {	// 页面加载之后, 获取页面中的对象
	nameObj = document.getElementById("name");
	priceObj = document.getElementById("price");
	remainObj = document.getElementById("remain");
	categoryObj = document.getElementById("category");
    descriptionObj = document.getElementById("description");
};

function checkForm() {			// 验证整个表单
	var bName = checkName();
	var bPrice = checkPrice();
	var bRemain = checkRemain();
	var bCategory = checkCategory();
    var bDescription = checkDescription();
	if(bName && bPrice && bRemain && bCategory && bDescription ==false)
    {
        alert("请认真输入");
        return false;
    }
    return true;// return false后, 事件将被取消
}

function checkName() {			// 验证商品名
	var value =nameObj.value;
	var msg = "";
	if (!value)
		msg = "必须填写：";
	return msg == "";
}

function checkPrice() {			// 验证价格
	var regex = /^[1-9]\d*$/;
	var value =priceObj.value;
	var msg = "";
	if (!value)
		msg = "必须填写：";
	else if (!regex.test(value))
		msg = "格式不合法：";
	return msg == "";
}

function checkRemain() {			// 验证库存
	var regex = /^[1-9]\d*$/;
	var value =remainObj.value;
	var msg = "";
	if (!value)
		msg = "必须填写：";
	else if (!regex.test(value))
		msg = "格式不合法：";
	return msg == "";
}
function checkCategory() {			// 验证类别
	var value =categoryObj.value;
	var msg = "";
	if (!value)
		msg = "必须填写：";
	return msg == "";
}
function checkDescription() {			// 验证描述
	var value =descriptionObj.value;
	var msg = "";
	if (!value)
		msg = "邮箱必须填写：";
	return msg == "";
}