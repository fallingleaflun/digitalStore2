var passwordObj;
var confirmObj;
var telObj;
var introduceObj;

var passwordMsg;
var confirmMsg;
var telMsg;
var introduceMsg;

window.onload = function() {	// 页面加载之后, 获取页面中的对象
	passwordObj = document.getElementById("password");
	confirmObj = document.getElementById("repassword");
    telObj = document.getElementById("tel");
    introduceObj = document.getElementById("infotextarea");
    

	passwordMsg = document.getElementById("passwordMsg");
	confirmMsg = document.getElementById("confirmMsg");
    telMsg = document.getElementById("telMsg");
    introduceMsg = document.getElementById("introduceMsg");
};

function checkForm() {			// 验证整个表单
	var bPassword = checkPassword();
	var bConfirm = checkConfirm();
    var bTel = checkTel();
    var bIntroduce = checkIntroduce();
	return bPassword && bConfirm && bTel && bIntroduce;	// return false后, 事件将被取消
}

function checkPassword() {		// 验证密码
	var regex = /^.{6,16}$/;			// 任意字符, 6到16位
	var value = passwordObj.value;
	var msg = "";
	if (!value)
		msg = "密码必须填写：";
	else if (!regex.test(value))
		msg = "密码不合法：";
	passwordMsg.innerHTML = msg;
	passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkConfirm() {		// 验证确认密码
	var passwordValue = passwordObj.value;
	var confirmValue = confirmObj.value;
	var msg = "";

    if(!confirmValue){
	    msg = "确认密码必须填写";
	}
	else	if (passwordValue != confirmValue){
		msg = "密码必须保持一致";
    }
	confirmMsg.innerHTML = msg;
	confirmObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkTel() {		// 验证手机号
	var regex = /^1(3|4|5|7|8)\d{9}$/;
	var value = telObj.value;
	var msg = "";
	if (!value)
		msg = "手机号必须填写！";
	else if (!regex.test(value))
		msg = "手机号不合法：";
	telMsg.innerHTML = msg;
	telObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkIntroduce() {		// 个人简介
	var regex = /select|update|delete|exec|count|'|"|=|;|>|</i;
	var value = introduceObj.value;
	var msg = "";
	if (value.length > 30)
		msg = "个人简介超长！";
	else if (regex.test(value))
		msg = "个人简介内容不合法：";
	introduceMsg.innerHTML = msg;
	introduceObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}
