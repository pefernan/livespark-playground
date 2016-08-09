package demo.client.shared;

import org.livespark.formmodeler.rendering.client.shared.FormModel;
import java.util.List;
import java.util.Arrays;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import javax.inject.Named;
import javax.validation.Valid;
import org.jboss.errai.common.client.api.annotations.MapsTo;
import java.lang.Override;

@Portable
@Bindable
@Named("DepartmentFormModel")
public class DepartmentFormModel extends FormModel
{

   @Valid
   private Department department;

   public Department getDepartment()
   {
      return department;
   }

   public void setDepartment(Department department)
   {
      this.department = department;
   }

   public DepartmentFormModel()
   {
   }

   public DepartmentFormModel(@MapsTo("department") Department department)
   {
      this.department = department;
   }

   @Override
   public List<Object> getDataModels()
   {
      return Arrays.<Object> asList(department);
   }
}