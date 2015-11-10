<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<div class="col-sm-3 col-md-2 sidebar">
  <ul class="nav nav-sidebar">
    <li class="active"><a href="ticket/manager">检验管理 <span class="sr-only">(current)</span></a></li>
    <li><a href="#">咨询管理 </a></li>
    <li><a href="#">信息发布 </a></li>
    <li><a href="#">会员管理 </a></li>
  </ul>
  <ul class="nav nav-sidebar">
    <li><a href="">最新利率</a></li>
    <li><a href="">关于我们</a></li>
  </ul>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("li[name='menu_li']").each(function(){
		$(this).click(function(){
			$("li[name='menu_li']").removeAttr("class");
			$(this).attr("class","active").css({cursor:"pointer"});
		});
	});
	var height = $(window).height()-25;
	$("#main_container").height(height);
});
function sendPost(url){
	$("#frame_site").attr("src",url);
	
}
</script>