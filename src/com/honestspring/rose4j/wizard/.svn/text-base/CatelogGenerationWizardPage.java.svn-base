package com.honestspring.rose4j.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.honestspring.rose4j.model.ModelProvider;
import com.honestspring.rose4j.model.Person;

public class CatelogGenerationWizardPage  extends WizardPage{
	  private TableViewer viewer;
	protected CatelogGenerationWizardPage(ISelection selection) {
		super("slave4j");
		setTitle("代码生成");
		setDescription("相应的包名设置");
		
	}

	@Override
	public void createControl(Composite parent) {
		    createViewer(parent);
		
	}
	 private void createViewer(Composite parent) {
		    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
		        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		    createColumns(parent, viewer);
		    final Table table = viewer.getTable();
		    table.setHeaderVisible(true);
		    table.setLinesVisible(true);

		    viewer.setContentProvider(new ArrayContentProvider());
		    // get the content for the viewer, setInput will call getElements in the
		    // contentProvider
		    viewer.setInput(ModelProvider.INSTANCE.getPersons());
		    // make the selection available to other views
		   // getSite().setSelectionProvider(viewer);
		    // set the sorter for the table

		    // define layout for the viewer
		    GridData gridData = new GridData();
		    gridData.verticalAlignment = GridData.FILL;
		    gridData.horizontalSpan = 2;
		    gridData.grabExcessHorizontalSpace = true;
		    gridData.grabExcessVerticalSpace = true;
		    gridData.horizontalAlignment = GridData.FILL;
		    viewer.getControl().setLayoutData(gridData);
		  }
	  private void createColumns(final Composite parent, final TableViewer viewer) {
		    String[] titles = { "First name", "Last name", "Gender", "Married" };
		    int[] bounds = { 100, 100, 100, 100 };

		    // first column is for the first name
		    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Person p = (Person) element;
		        return p.getFirstName();
		      }
		    });

		    // second column is for the last name
		    col = createTableViewerColumn(titles[1], bounds[1], 1);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Person p = (Person) element;
		        return p.getLastName();
		      }
		    });

		    // now the gender
		    col = createTableViewerColumn(titles[2], bounds[2], 2);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Person p = (Person) element;
		        return p.getGender();
		      }
		    });

		    // now the status married
		    col = createTableViewerColumn(titles[3], bounds[3], 3);
		    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        return null;
		      }

		    });

		  }
	  private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
		        SWT.NONE);
		    final TableColumn column = viewerColumn.getColumn();
		    column.setText(title);
		    column.setWidth(bound);
		    column.setResizable(true);
		    column.setMoveable(true);
		    return viewerColumn;
		  }

		  public void setFocus() {
		    viewer.getControl().setFocus();
		  }
		  public TableViewer getViewer() {
			    return viewer;
			  }
}
