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
    <script type="text/javascript" charset="utf-8" src="resources/UEditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="resources/UEditor/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="resources/UEditor/lang/zh-cn/zh-cn.js"></script>
  </head>
  <body>
    <jsp:include page="top.jsp"></jsp:include>

    <div class="container-fluid">
      <div class="row">
        <jsp:include page="left.jsp"></jsp:include>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="user/modifyNews" method="POST">
					<input type="hidden" name="id" value="${news.id }"/>
					<input type="text" name="title" class="form-control" placehsolder="标题" value="${news.title }"><br />
					<script id="editor" name="content" type="text/plain" style="min-height:380px;">${news.content }</script>
					<br />
					<button type="submit" class="btn btn-primary">保存</button>
				</form>
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
    var ue = UE.getEditor('editor');
    
    function submit_form(){
    	$("#ticketManagerForm").submit();
    }
    function pass(id){
    	$.post("ticket/verify_ticket",{id:id,verifyResult:1},function(result){
    		if(result.status == 0){
    			alert("验证成功");
    			submit_form();
    		}
    		
    	});
    }
    function fail(id){
    	$('#myModal').modal('show');
    }
    function openWin(url){
    	window.open(url,'newwindow','height=auto,width=auto,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') ;
    }
    </script>
  </body>
</html>
