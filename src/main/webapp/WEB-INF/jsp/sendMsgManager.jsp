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
				<form action="" method="POST">
					发给所有用户
					<textarea class="form-control" id="msg" rows="3" name="msg"></textarea>
					<br />
					<button type="button" onclick="sendMsg()" class="btn btn-primary">发送</button>
				</form>
			</div>
			<br />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			发送消息更多功能
			<a target="_href" href="https://mp.weixin.qq.com/">点击这里</a>,
			登录后左边第一个菜单"群发功能"
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
    
    function sendMsg(){
    	var text = $("#msg").val();
    	if(text==null || text == ""){
    		alert("消息内容不能为空");
    	}
    	if(confirm("确定要发送该消息吗?")){
    		$.post("weixin/send/batch_msg",{value:text},function(result){
        		if(result.status == 0){
        			alert("发送成功");
        			$("#msg").val("");
        		}
        		
        	});
    	}
    }
    function openWin(url){
    	window.open(url,'newwindow','height=auto,width=auto,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') ;
    }
    </script>
  </body>
</html>
