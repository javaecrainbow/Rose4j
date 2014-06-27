package com.honestspring.rose4j.model;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jdt.core.ICompilationUnit;

public class ClassNameInfo
{
	private String entityClassName;

	public ClassNameInfo(ICompilationUnit compilationUnit)
	{
		String entityFileName = compilationUnit.getElementName();
		this.entityClassName = entityFileName.substring(0, entityFileName.lastIndexOf("."));//entity类名
	}

	/**
	 * 实体类名称
	 * @return
	 */
	public String getEntityClassName()
	{
		return entityClassName;
	}

	/**
	 * 实体对象名称
	 * @return
	 */
	public String getEntityObjectName()
	{
		return StringUtils.uncapitalize(entityClassName);
	}

	/**
	 * dao类名称
	 * @return
	 */
	public String getDaoClassName()
	{
		return entityClassName + "Dao";
	}
	/**
	 * dao对象名称
	 * @return
	 */
	public String getDaoObjectName()
	{
		return StringUtils.uncapitalize(entityClassName + "Dao");
	}

	/**
	 * service类名称
	 * @return
	 */
	public String getServicClassName()
	{
		return entityClassName + "Service";
	}

	/**
	 * service对象名称
	 * @return
	 */
	public String getServicObjectName()
	{
		return StringUtils.uncapitalize(entityClassName + "Service");
	}

	/**
	 * controller类名称
	 * @return
	 */
	public String getActionClassName()
	{
		return entityClassName + "Controller";
	}
	public String getAjaxClassName(){
		return "ListViewAjaxController";
	}
	/**
	 * controller对象名称
	 * @return
	 */
	public String getActionObjectName()
	{
		return StringUtils.uncapitalize(entityClassName + "Controller");
	}

}
