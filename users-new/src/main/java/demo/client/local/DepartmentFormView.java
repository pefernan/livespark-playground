package demo.client.local;

import org.livespark.formmodeler.rendering.client.view.FormView;
import demo.client.shared.DepartmentFormModel;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import javax.inject.Named;
import java.util.List;
import java.util.ArrayList;
import demo.client.shared.Department;
import org.gwtbootstrap3.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.livespark.formmodeler.rendering.client.shared.fields.SubForm;
import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import demo.client.local.AddressFormView;
import org.livespark.formmodeler.rendering.client.shared.fields.SubFormModelAdapter;

@Templated
@Named("DepartmentFormView")
public class DepartmentFormView extends FormView<DepartmentFormModel>
{

   @Inject
   @Bound(property = "department.id")
   @DataField
   private TextBox department_id;
   @Inject
   @Bound(property = "department.name")
   @DataField
   private TextBox department_name;
   @Inject
   @Bound(property = "department.description")
   @DataField
   private TextBox department_description;
   @DataField
   private SubForm department_address = new SubForm(
         new Department_addressSubFormModelAdapter());

   @Override
   protected int getEntitiesCount()
   {
      return 1;
   }

   @Override
   protected List getEntities()
   {
      List entities = new ArrayList();
      Object department = getModel().getDepartment();
      if (department != null)
         entities.add(department);
      return entities;
   }

   @Override
   protected void initEntities()
   {
      if (getModel().getDepartment() == null)
         getModel().setDepartment(new Department());
   }

   @Override
   protected void initForm()
   {
      validator.registerInput("department_id", department_id);
      validator.registerInput("department_name", department_name);
      validator.registerInput("department_description",
            department_description);
      validator.registerInput("department_address", department_address);
      updateNestedModels(true);
   }

   @Override
   public void beforeDisplay()
   {
   }

   @Override
   public boolean doExtraValidations()
   {
      boolean valid = true;
      if (!department_address.validate() && valid)
      {
         valid = false;
      }
      return valid;
   }

   public class Department_addressSubFormModelAdapter implements
         SubFormModelAdapter<Address, AddressFormModel>
   {
      @Override
      public Class<AddressFormView> getFormViewType()
      {
         return AddressFormView.class;
      }

      @Override
      public AddressFormModel getFormModelForModel(Address model)
      {
         return new AddressFormModel(model);
      }
   }

   protected void updateNestedModels(boolean init)
   {
      demo.client.shared.Address address = getModel().getDepartment()
            .getAddress();
      if (address == null && init)
      {
         address = new demo.client.shared.Address();
         getModel().getDepartment().setAddress(address);
      }
      department_address.setModel(address);
   }

   @Override
   public void setModel(DepartmentFormModel model)
   {
      super.setModel(model);
      updateNestedModels(false);
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
      department_name.setReadOnly(readOnly);
      department_description.setReadOnly(readOnly);
      department_address.setReadOnly(readOnly);
   }
}