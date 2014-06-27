package com.honestspring.rose4j.model;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import rose4j.Activator;

public class PluginProject
{
	/**
	 * 取得插件的资源目录
	 * @param filename
	 * @return
	 */
	private static String getPluginResourcePath(String filename)
	{
		String path = null;
		URL url = Platform.getBundle(Activator.PLUGIN_ID).getEntry("resource/" + filename);
		try
		{
			path = FileLocator.toFileURL(url).getPath();
			//去除第一个"/"
			path = path.substring(path.indexOf("/") + 1, path.length());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * 取得webRoot资源路径
	 * @return
	 */
	public static String getWebRoot()
	{
		return getPluginResourcePath("WebRoot");
	}
	
	/**
	 * 取得src资源路径
	 * @return
	 */
	public static String getSrc()
	{
		return getPluginResourcePath("src");
	}
	public static String getResources(){
		return getPluginResourcePath("resources");
	}
}
