<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/admin/css/Style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/main2.css" />
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
     <!-- 引入 ECharts 文件 -->
    <script src="${pageContext.request.contextPath}/admin/js/echarts.js"></script>
</HEAD>

<p:user></p:user>
<body class="linear1">
    <div id="header"><img class="img_logo" src="${pageContext.request.contextPath}/admin/images/top_11.png" style="	min-width:100%;
	max-width:100%;
	height:60px;"></div>
    <div id="section">
        <div id="nav">
            <ul>
                <li>功能</li>
                <li><a href="${pageContext.request.contextPath}/listProduct">所属商品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/findOrders" >订单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/statistic">销售统计</a></li>
                <li><a href="${pageContext.request.contextPath}/getAllTomaru">用戶停留时间统计</a></li>
                <li><a href="${pageContext.request.contextPath}/GetIpRecordServlet">用戶操作统计</a></li>
                <li><a href="${pageContext.request.contextPath}/client/logout">退出登录</a></li>
            </ul>
        </div>
        <div id="article" border="8" height="1000px">
            <table>
                <tr>
                    <td>
                        <div id="pan" style="width: 800px;height:400px;"></div>
                    </td>
                </tr>            
            </table>
        </div>
    </div>
</body>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('pan'));
    // 指定图表的配置项和数据
    option = {
        title:[
                {
                    text:"近一个月的日收入",
                    left:'25%',
                    top:'1%',
                    textAlign:'center'
                },
                {
                    text:"各类别收入占比",
                    left:'73%',
                    top:'1%',
                    textAlign:'center'
                },
                
            ],
        grid: [
        {x: '10%', y: '40%', width: '38%', height: '38%'},//折线图位置控制
        ],
        xAxis: [{
            gridIndex: 0,name:"日",
            data: [<c:forEach items="${dayList}" var="days">${days.key},</c:forEach>]},
        ],
        yAxis: [{
            name: '收入',
            splitLine: {
                show: true
            },
            gridIndex: 0
        },
        ],
        series: [{
                type: 'line',
                xAxisIndex: 0, //指定折线图数据显示到：grid坐标系：0
                yAxisIndex: 0,
                showSymbol: false,
                data: [
                    <c:forEach items="${dayList}" var="days">
                    ${days.value},
                    </c:forEach>
                ] //折线图y轴数据赋值
            },
            {
                name: '销售数量',
                type: 'pie',
                radius : '55%',
                center: ['80%', '60%'],
                data:[
                    <c:forEach items="${cateList}" var="goods">
                    {value:"${goods.value}", name:"${goods.key}"},
                    </c:forEach>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    
     // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>


</HTML>