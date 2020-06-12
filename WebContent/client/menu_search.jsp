<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
//鼠标点击搜索框时执行
function my_click(obj, myid){
	//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
	if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
	  document.getElementById(myid).value = '';
	  obj.style.color='#000';
	}
}
//鼠标不聚焦在搜索框时执行
function my_blur(obj, myid){
	//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
	if (document.getElementById(myid).value == ''){
	 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
	 obj.style.color='#999';
 }
}

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
</script>
<div id="divmenu">
		<a href="${pageContext.request.contextPath}/showProductByPage?category=手机">手机</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=笔记本">笔记本</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=相机">相机</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=影音娱乐">影音娱乐</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=数码配件">数码配件</a>
		<a href="${pageContext.request.contextPath}/GetRecommandServlet">猜你喜欢</a> 
</div>
<div id="divsearch">
<form action="${pageContext.request.contextPath }/MenuSearchServlet" id="searchform">
    <input type="text" name="textfield" class="inputtable" id="textfield"
    style="height:40px;width:600px"
    onmouseover="this.focus();"
    onclick="my_click(this, 'textfield');"
    onBlur="my_blur(this, 'textfield');"/> 
    &nbsp;
    <a href="#">
        <img src="${pageContext.request.contextPath}/client/images/searchbutton.png" width="40" height="40" border="0" style="margin-bottom:-15px" onclick="search()"/> 
    </a>
</form>
</div>