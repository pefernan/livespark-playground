package demo.client.local;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.gwtbootstrap3.client.ui.SimpleCheckBox;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.shared.fields.MultipleSubForm;
import org.livespark.formmodeler.rendering.client.shared.fields.MultipleSubFormModelAdapter;
import org.livespark.formmodeler.rendering.client.shared.fields.SubForm;
import org.livespark.formmodeler.rendering.client.shared.fields.SubFormModelAdapter;
import org.livespark.formmodeler.rendering.client.view.FormView;
import org.uberfire.ext.widgets.table.client.ColumnMeta;

import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import demo.client.shared.User;
import demo.client.shared.UserFormModel;

@Templated
@Named("UserFormView")
public class UserFormView extends FormView<User, UserFormModel>
{

   @Inject
   @Bound(property = "user.id")
   @DataField
   private TextBox user_id;
   @Inject
   @Bound(property = "user.name")
   @DataField
   private TextBox user_name;
   @Inject
   @Bound(property = "user.lastName")
   @DataField
   private TextBox user_lastName;
   @Inject
   @Bound(property = "user.birthday")
   @DataField
   private DateTimePicker user_birthday;
   @Inject
   @Bound(property = "user.married")
   @DataField
   private SimpleCheckBox user_married;
   @Inject
   @Bound(property = "user.title")
   @DataField
   private TextBox user_title;
   @DataField
   private final SubForm user_address = new SubForm(
         new User_addressSubFormModelAdapter());
   @DataField
   private final MultipleSubForm user_adresses = new MultipleSubForm(
         new User_adressesMultipleSubFormModelAdapter());

   @Override
   protected int getEntitiesCount()
   {
      return 1;
   }

   @Override
   protected List getEntities()
   {
      final List entities = new ArrayList();
      final Object user = getModel().getUser();
      if (user != null)
         entities.add(user);
      return entities;
   }

   @Override
   protected void initEntities()
   {
      if (getModel().getUser() == null)
         getModel().setUser(new User());
   }

   @Override
   protected void initForm()
   {
      validator.registerInput("user_id", user_id);
      validator.registerInput("user_name", user_name);
      validator.registerInput("user_lastName", user_lastName);
      validator.registerInput("user_birthday", user_birthday);
      validator.registerInput("user_married", user_married);
      validator.registerInput("user_title", user_title);
      validator.registerInput("user_address", user_address);
      updateNestedModels(true);
      validator.registerInput("user_adresses", user_adresses);
   }

   @Override
   public void beforeDisplay()
   {
   }

   @Override
   public boolean doExtraValidations()
   {
      boolean valid = true;
      if (!user_address.validate() && valid)
      {
         valid = false;
      }
      return valid;
   }

   public class User_addressSubFormModelAdapter implements
         SubFormModelAdapter<Address, AddressFormModel>
   {
      @Override
      public Class<AddressFormView> getFormViewType()
      {
         return AddressFormView.class;
      }

      @Override
      public AddressFormModel getFormModelForModel(final Address model)
      {
         return new AddressFormModel(model);
      }
   }

   protected void updateNestedModels(final boolean init)
   {
      demo.client.shared.Address address = getModel().getUser().getAddress();
      if (address == null && init)
      {
         address = new demo.client.shared.Address();
         getModel().getUser().setAddress(address);
      }
      user_address.setModel(address);
      List adresses = getModel().getUser().getAdresses();
      if (adresses == null && init)
      {
         adresses = new ArrayList<demo.client.shared.Address>();
         getModel().getUser().setAdresses(adresses);
      }
      user_adresses.setModel(adresses);
   }

   @Override
   public void setModel(final UserFormModel model)
   {
      super.setModel(model);
      updateNestedModels(false);
   }

   public class User_adressesMultipleSubFormModelAdapter
         implements
         MultipleSubFormModelAdapter<List<Address>, Address, AddressFormModel, AddressFormModel>
   {
      @Override
      public Class<AddressFormView> getCreationForm()
      {
         return AddressFormView.class;
      }

      @Override
      public Class<AddressFormView> getEditionForm()
      {
         return AddressFormView.class;
      }

      @Override
      public AddressFormModel getEditionFormModel(final Address model)
      {
         return new AddressFormModel(model);
      }

      @Override
		public List<ColumnMeta<Address>> getCrudColumns() {
			final List<ColumnMeta<Address>> columnMetas = new ArrayList<>();
			return columnMetas;
		}
   }

   @Override
   public void setReadOnly(final boolean readOnly)
   {
      user_name.setReadOnly(readOnly);
      user_lastName.setReadOnly(readOnly);
      user_birthday.setReadOnly(readOnly);
      user_married.setEnabled(!readOnly);
      user_title.setReadOnly(readOnly);
      user_address.setReadOnly(readOnly);
   }
}