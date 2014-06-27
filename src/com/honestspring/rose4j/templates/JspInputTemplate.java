package com.honestspring.rose4j.templates;

import java.util.List;
import com.honestspring.rose4j.model.*;

public class JspInputTemplate
{
  protected static String nl;
  public static synchronized JspInputTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    JspInputTemplate result = new JspInputTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<%@ page language=\"java\" contentType=\"text/html; charset=utf-8\" pageEncoding=\"utf-8\"%>" + NL + "<%@ taglib uri=\"/SYSVIEW\" prefix=\"sysview\"%>" + NL + "<%@include file=\"../../hs_common.jsp\"%>" + NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" + NL + "<html>" + NL + "  <head>" + NL + "  " + NL + "  </head>" + NL + "" + NL + "  <body>" + NL + "  \t<!-- 验证还是jquery-validation好用，这里省事没用 -->" + NL + "\t<form id=\"screenForm\" method=\"post\" style=\"margin: 10;text-align: center;\">" + NL + "\t\t<table width=\"100%\">" + NL + "\t\t<sysview:screen module=\"";
  protected final String TEXT_2 = "\"></sysview:screen>" + NL + "\t\t\t</table>" + NL + "\t\t<div style=\"padding-top: 80px\">" + NL + "\t\t<a href=\"#\" id=\"btn-back\" onclick=\"closeWindow();\" class=\"easyui-linkbutton\" iconCls=\"icon-back\">返回</a>" + NL + "\t\t<a href=\"#\" id=\"btn-add\" onclick=\"addOrUpdateUser('${option}');\" class=\"easyui-linkbutton\" iconCls=\"icon-save\">保存</a>" + NL + "\t\t</div>" + NL + "\t</form>" + NL + "\t<script type=\"text/javascript\">" + NL + "  \t  $(function(){" + NL + "  \t   // 时间设置" + NL + "             \t$(\"input[id='timestamp']\").each(function(){" + NL + "             \t\t$(this).bind(\"focus\",function(){WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})});" + NL + "             \t});" + NL + "  \t\t\t//$(\".registerform\").Validform();  //就这一行代码！下面是演示两种不同的验证效果;" + NL + "  \t\t\t//提示效果二;" + NL + "  \t\t\t$(\"#screenForm\").Validform({" + NL + "  \t\t\t\ttiptype:2," + NL + "  \t\t\t\tajaxPost:true," + NL + "  \t\t\t\tcallback:function(data){" + NL + "  \t\t\t\t\t//返回数据data是json格式，{\"info\":\"demo info\",\"status\":\"y\"}" + NL + "  \t\t\t\t\t//info: 输出提示信息;" + NL + "  \t\t\t\t\t//status: 返回提交数据的状态,是否提交成功。如可以用\"y\"表示提交成功，\"n\"表示提交失败，在ajax_post.php文件返回数据里自定字符，主要用在callback函数里根据该值执行相应的回调操作;" + NL + "  \t\t\t\t\t//你也可以在ajax_post.php文件返回更多信息在这里获取，进行相应操作；" + NL + "  \t\t\t\t\t" + NL + "  \t\t\t\t\t//这里执行回调操作;" + NL + "  \t\t\t\t\tif(data.status==\"y\"){" + NL + "  \t\t\t\t\t\tsetTimeout(function(){" + NL + "  \t\t\t\t\t\t\t$.Hidemsg(); //公用方法关闭信息提示框;" + NL + "  \t\t\t\t\t\t},2000);" + NL + "  \t\t\t\t\t}" + NL + "  \t\t\t\t}" + NL + "  \t\t\t});" + NL + "  \t\t});" + NL + "   </script>" + NL + "  </body>" + NL + "  \t " + NL + "</html>";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	JspTemplateArgs args = (JspTemplateArgs)argument;
	String modeName = args.getModeName();
	String entityName = args.getEntityName();
	String jspName = args.getJspName();
	
	List<EntityFieldInfo> entityFieldInfoList = args.getEntityFieldInfoList();
	
	String entityPackageName = args.getPackageNameInfo().getEntityPackageName();
	String daoPackageName = args.getPackageNameInfo().getDaoPackageName();
	String servicePackageName = args.getPackageNameInfo().getServicPackageName();
	String actionPackageName = args.getPackageNameInfo().getActionPackageName();
	
	String entityClassName = args.getClassNameInfo().getEntityClassName();
	String daoClassName = args.getClassNameInfo().getDaoClassName();
	String serviceClassName = args.getClassNameInfo().getServicClassName();
	String actionClassName = args.getClassNameInfo().getActionClassName();
	
	String entityObjectName = args.getClassNameInfo().getEntityObjectName();
	String daoObjectName = args.getClassNameInfo().getDaoObjectName();
	String serviceObjectName = args.getClassNameInfo().getServicObjectName();
	String actionObjectName = args.getClassNameInfo().getActionObjectName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
