package com.honestspring.rose4j.model;

import org.eclipse.jdt.core.IPackageFragment;

/**
 * 
 * @author lijingjing
 *
 */
public class PackageNameInfo
{
	private String entityPackageName;//entity包名
	private String modeName;//模块名

	/**
	 * 构造方法
	 * @param packageFragment
	 */
	public PackageNameInfo(IPackageFragment packageFragment)
	{
		this.entityPackageName = packageFragment.getElementName();
		String basePackageName = entityPackageName.substring(0, entityPackageName.lastIndexOf("."));
		this.modeName = basePackageName.substring(basePackageName.lastIndexOf(".") + 1, basePackageName.length());//模块名
	}

	/**
	 * 获取实体类包名
	 * @return
	 */
	public String getEntityPackageName()
	{
		return entityPackageName;
	}

	/**
	 * 获取dao包名
	 * @return
	 */
	public String getDaoPackageName()
	{
		return getPackageName(entityPackageName, "dao");
	}

	/**
	 * 获取service包名
	 * @return
	 */
	public String getServicPackageName()
	{
		return getPackageName(entityPackageName, "service");
	}

	/**
	 * 获取action包名
	 * @return
	 */
	public String getActionPackageName()
	{
		return getPackageName(entityPackageName, "controller");
	}

	public String getAjaxPackageName(){
		return getPackageName(entityPackageName, "ajax");
	}
	/**
	 * 获取模块名
	 * @return
	 */
	public String getModeName()
	{
		return modeName;
	}

	/**
	 * 取得包名
	 * @param entityPackageName
	 * @param type
	 * @return
	 */
	private String getPackageName(String entityPackageName, String type)
	{
		if (entityPackageName.indexOf(".") != -1)
		{
			int index = entityPackageName.lastIndexOf(".");
			return entityPackageName.substring(0, index) + "." + type;
		} else
		{
			return type;
		}
	}

}
