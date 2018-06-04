<%--
  Created by IntelliJ IDEA.
  User: Xena
  Date: 2018/5/29
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--获得项目路径--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>聊天记录</title>
    <script src="<%=basePath%>/js/jquery-1.10.1.min.js">
    $(function(){
        //获得按钮
        $("#btn").click(
            function(){
                //获得我们的文本的输入内容
                var wcont ="<span>"+$("#content").val()+":我</span><br/>";
                //将span标签填充到div中
                $("#main").append(wcont);
                var value=$("#content").val("");//记录文本框中的内容
                $("#content").val("");//将文本框置空

                //对方回应，数据库查询，这里是异步，使用ajax
                //输入1.选择支付，将支付的id发给控制层，通过id找到该类型下的所有信息
                var cid=${requestScope.messageCatory[value-1].id};
                $.ajax({
                    tyep:"get",
                    url:"${pageContext.request.contextPath}/selectMessage",
                    data:"id="+cid,
                    success:function(mlist) {
                        //mlist接收处理器（controller）传过来的json格式的值
                        //通过js去绘制页面
                        for(var i=0;i<mlist.length;i++){
                            var message=mlist[i];//获取到列表中的每一个消息
                            var mzhan="<p>"+(i+1)+","+message.mname+"</p>";
                            $("#main").append(mzhan);
                        }
                    }
                });

            }
        )
    });


    </script>
</head>
<body>

<center>

    <div id="main" style="border: 1px solid black; width: 600px;height: 600px ">
        客服狗蛋：
            <c:forEach items="${messageCatory}" var="catory" varStatus="s">
                ${s.index+1},${catory.mcatory}<br/>
            </c:forEach>
            亲，你有什么要求？

    </div>

    <p><input id="content" name="content" style="width: 450px">
        <input type="button" value="提交" id="btu">
    </p>
</center>


</body>
</html>
