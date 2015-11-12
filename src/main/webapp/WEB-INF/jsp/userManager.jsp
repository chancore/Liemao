<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>猎猫汇票-运营平台</title>
    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="resources/css/dashboard.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <jsp:include page="top.jsp"></jsp:include>

    <div class="container-fluid">
      <div class="row">
        <jsp:include page="left.jsp"></jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="row">
        	<form action="user/manager" method="POST" id="ticketManagerForm">
        	<div class="col-md-4">
	        	<input name="phone" value="${user.phone }"/>
        	</div>
        	
        	<div class="col-md-2">
	        	<button type="button" class="btn btn-primary" onclick="submit_form()">搜索</button>
        	</div>
        	</form>
        </div>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>手机</th>
                  <th>姓名</th>
                  <th>邮箱</th>
                  <th>性别</th>
                  <th>地址</th>
                  <th>注册时间</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${list }" var="i">
                <tr>
                  <td>${i.id }</td>
                  <td>${i.phone }</td>
                  <td >${i.name }</td>
                  <td >${i.email }</td>
                  <td>
                  	<c:if test="${i.gender == 0 }">未设置</c:if>
                  	<c:if test="${i.gender == 1 }">男</c:if>
                  	<c:if test="${i.gender == 2 }">女</c:if>
                  </td>
                  <td>
                  	${i.address }
                  </td>
                  <td>
                  ${i.createTime }
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
	<!-- Modal -->  
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="resources/js/ie10-viewport-bug-workaround.js"></script>
    <script src="http://files.cnblogs.com/rubylouvre/bootstrap-modal.js"></script>
    <script type="text/javascript">
    function submit_form(){
    	$("#ticketManagerForm").submit();
    }
    function pass(id){
    	var content = $("#tx_"+id).val();
    	$.post("user/feedback/reply",{id:id,feedback:content},function(result){
    		if(result.status == 0){
    			alert("保存成功");
    			submit_form();
    		}
    	});
    }
    function openWin(url){
    	window.open(url,'newwindow','height=auto,width=auto,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') ;
    }
    </script>
  </body>
</html>
