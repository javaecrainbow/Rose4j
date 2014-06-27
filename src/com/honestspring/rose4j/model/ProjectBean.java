package com.honestspring.rose4j.model;

import java.io.File;
import java.io.Serializable;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public class ProjectBean implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String root;
	private String src;
	private String webRoot;
	private String webRootName;
	private String webInf;
	private String lib;
	private IProject project;
	private IJavaProject javaProject;
	private String resources;
	public ProjectBean(ISelection selection) {
		// 取得项目根目录
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		IJavaElement t = (IJavaElement) obj;
		javaProject = t.getJavaProject();
		project = t.getResource().getProject();
		// 项目名称
		name = project.getName();
		root = project.getLocation().toString();
		// 取得源目录
		src = root + "/src";
		resources=root+"/resources";
		// 取得WEB-INF目录
		webInf = getWebInf(root).replaceAll("\\\\", "/");
		// 取得webRoot目录
		webRootName = getWebRootName(webInf);
		webRoot = root + "/" + getWebRootName(webInf);
		// 取得lib目录
		lib = webInf + "/lib";
	}

	/**
	 * 取得WEB-INF路径
	 * 
	 * @param root
	 * @return
	 */
	private String getWebInf(String root) {
		String webinfo = null;
		File f = new File(root);
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					if (file.getName().equals("WEB-INF")) {
						webinfo = file.getPath();
						return webinfo;
					} else {
						webinfo = getWebInf(file.getPath());
					}
				}
			}
		}
		return webinfo;
	}

	/**
	 * 取得WebRoot的名称
	 * 
	 * @param Projectpath
	 * @return "WebRoot"
	 */
	private String getWebRootName(String webInf) {
		return webInf.split("/")[(webInf.split("/").length - 2)];
	}  

	/**
	 * 刷新工程
	 */
	public void refresh() {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}

	public String getWebRootName() {
		return webRootName;
	}

	public void setWebRootName(String webRootName) {
		this.webRootName = webRootName;
	}

	public String getWebInf() {
		return webInf;
	}

	public void setWebInf(String webInf) {
		this.webInf = webInf;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public IJavaProject getJavaProject() {
		return javaProject;
	}

	public void setJavaProject(IJavaProject javaProject) {
		this.javaProject = javaProject;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

}
