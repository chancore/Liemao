<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
  <ul class="nav nav-sidebar">
    <li name="menu_li" <c:if test="${url==1 }">class="active"</c:if>><a href="ticket/manager?verifyResult=0">检验管理 <span class="sr-only">(current)</span></a></li>
    <li name="menu_li" <c:if test="${url==2 }">class="active"</c:if>><a href="user/feedback/manager">咨询管理 </a></li>
    <!-- <li name="menu_li" <c:if test="${url==3 }">class="active"</c:if>><a href="#">信息发布 </a></li> -->
    <li name="menu_li" <c:if test="${url==4 }">class="active"</c:if>><a href="user/manager">会员管理 </a></li>
  </ul>
  <ul class="nav nav-sidebar">
    <li name="menu_li" <c:if test="${url==5 }">class="active"</c:if>><a href="user/zxlvManager">最新利率</a></li>
    <li name="menu_li" <c:if test="${url==6 }">class="active"</c:if>><a href="user/gywmManager">关于我们</a></li>
  </ul>
  <ul class="nav nav-sidebar">
    <li name="menu_li" <c:if test="${url==7 }">class="active"</c:if>><a href="user/sendMsgManager">发送消息</a></li>
  </ul>
</div>