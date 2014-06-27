package com.honestspring.rose4j.wizard;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class CatelogGenerationWizard extends Wizard implements INewWizard{
	private CatelogGenerationWizardPage page;
	private ISelection selection;
	@Override
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		this.selection = arg1;
		
	}
	@Override
	public void addPages()
	{
		page = new CatelogGenerationWizardPage(selection);
		addPage(page);
	}
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}
	
}