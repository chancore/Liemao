<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>图片上传成功！</title>
<style>
* {
	padding: 0;
	margin: 0;
}

html {
	font-size: 12px;
}

body {
	background-color: #f3f2ef;
}

body {
	line-height: 1;
}

.booking .common-title {
	padding: 2rem 0 1rem;
}

.common-title {
	text-align: center;
	font-size: 2.5rem;
	color: #4f4f4f;
}

.booking .common-dec {
	line-height: 1.9rem;
	font-size: 1.6rem;
}

.common-dec {
	font-weight: 400;
	font-size: 1.8rem;
	color: #ffb049;
	text-align: center;
}
</style>
</head>

<body>
	<header> </header>
	<!--end of header-->
	<article>
		<div class="content">
			<div class="booking">
				<p class="common-title" style="margin-top: 35%;">票据上传成功</p>
				<p class="common-dec">请到我的查验中查看详情</p>
			</div>
			<!--end of position-->
		</div>
		<!--end of content-->
	</article>
	<!--end of article-->
	<footer> </footer>
	<!--end of footer-->
</body>
</html>