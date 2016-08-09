package demo.client.local;

import java.util.ArrayList;
import java.util.List;

import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.view.ListView;
import org.uberfire.ext.widgets.table.client.ColumnMeta;

import com.google.gwt.user.cellview.client.TextColumn;

import demo.client.shared.Department;
import demo.client.shared.DepartmentFormModel;

@Templated
public class DepartmentListView extends ListView<Department, DepartmentFormModel>
{

   @Override
   public String getListTitle()
   {
      return "Department";
   }

   @Override
   public String getFormTitle()
   {
      return "Department Form";
   }

   @Override
   protected String getFormId()
   {
      return "Department Form";
   }

   @Override
	public List<ColumnMeta<Department>> getCrudColumns() {
		final List<ColumnMeta<Department>> columnMetas = new ArrayList<>();
		final ColumnMeta<Department> id_columnMeta = new ColumnMeta<>(
				new TextColumn<Department>() {
					@Override
					public String getValue(final Department model) {
						final Object value = model.getId();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "ID #");
		columnMetas.add(id_columnMeta);
		final ColumnMeta<Department> name_columnMeta = new ColumnMeta<>(
				new TextColumn<Department>() {
					@Override
					public String getValue(final Department model) {
						final Object value = model.getName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Dep. Name");
		columnMetas.add(name_columnMeta);
		final ColumnMeta<Department> description_columnMeta = new ColumnMeta<>(
				new TextColumn<Department>() {
					@Override
					public String getValue(final Department model) {
						final Object value = model.getDescription();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Dep. Description");
		columnMetas.add(description_columnMeta);
		return columnMetas;
	}

   @Override
   public Department getModel(final DepartmentFormModel formModel)
   {
      return formModel.getDepartment();
   }

   @Override
   public DepartmentFormModel createFormModel(final Department department)
   {
      final DepartmentFormModel formModel = new DepartmentFormModel();
      formModel.setDepartment(department);
      return formModel;
   }

   @Override
    public Department newModel() {
       return new Department();
    }
}