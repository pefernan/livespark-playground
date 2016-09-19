package demo.client.local;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gwt.user.cellview.client.TextColumn;
import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import demo.client.shared.AddressRestService;
import demo.client.shared.User;
import demo.client.shared.UserFormModel;
import org.gwtbootstrap3.client.ui.SimpleCheckBox;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.kie.workbench.common.forms.common.rendering.client.widgets.typeahead.BindableTypeAhead;
import org.livespark.flow.cdi.api.FlowComponent;
import org.livespark.formmodeler.rendering.client.shared.fields.MultipleSubForm;
import org.livespark.formmodeler.rendering.client.shared.fields.MultipleSubFormModelAdapter;
import org.livespark.formmodeler.rendering.client.shared.fields.SubFormModelAdapter;
import org.livespark.formmodeler.rendering.client.view.FormView;
import org.livespark.formmodeler.rendering.client.widgets.typeahead.LiveSparkStaticDataset;
import org.uberfire.ext.widgets.table.client.ColumnMeta;

@Templated
@Named("UserFormView")
@FlowComponent
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


    private final String user_address_fieldMask = "{street} {num}, {cp} {city}";

    @DataField
    @Bound(property = "user.address")
    private BindableTypeAhead<Address> user_address = new BindableTypeAhead<Address>( user_address_fieldMask,
                                                                                      new LiveSparkStaticDataset<Address>(
                                                                                              user_address_fieldMask,
                                                                                              AddressRestService.class ) );

   @DataField
   private MultipleSubForm user_adresses = new MultipleSubForm(
         new User_adressesMultipleSubFormModelAdapter());

   @Override
   protected int getEntitiesCount()
   {
      return 1;
   }

   @Override
   protected List getEntities()
   {
      List entities = new ArrayList();
      Object user = getModel().getUser();
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
      return true;
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
      public AddressFormModel getFormModelForModel( Address model)
      {
         return new AddressFormModel( model);
      }
   }

   @Override
   protected void updateNestedModels(boolean init)
   {
   }

   @Override
   public void setModel(UserFormModel model)
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
      public AddressFormModel getEditionFormModel( Address model)
      {
         return new AddressFormModel( model);
      }

      @Override
		public List<ColumnMeta<Address>> getCrudColumns() {
			List<ColumnMeta<Address>> columnMetas = new ArrayList<>();
			ColumnMeta<Address> id_columnMeta = new ColumnMeta<Address>(
					new TextColumn<Address>() {
						@Override
						public String getValue(Address model) {
							Object value = model.getId();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "ID #");
			columnMetas.add(id_columnMeta);
			ColumnMeta<Address> street_columnMeta = new ColumnMeta<Address>(
					new TextColumn<Address>() {
						@Override
						public String getValue(Address model) {
							Object value = model.getStreet();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "Street Name");
			columnMetas.add(street_columnMeta);
			ColumnMeta<Address> num_columnMeta = new ColumnMeta<Address>(
					new TextColumn<Address>() {
						@Override
						public String getValue(Address model) {
							Object value = model.getNum();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "Num #");
			columnMetas.add(num_columnMeta);
			ColumnMeta<Address> cp_columnMeta = new ColumnMeta<Address>(
					new TextColumn<Address>() {
						@Override
						public String getValue(Address model) {
							Object value = model.getCp();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "CP");
			columnMetas.add(cp_columnMeta);
			ColumnMeta<Address> city_columnMeta = new ColumnMeta<Address>(
					new TextColumn<Address>() {
						@Override
						public String getValue(Address model) {
							Object value = model.getCity();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "City");
			columnMetas.add(city_columnMeta);
			ColumnMeta<Address> country_columnMeta = new ColumnMeta<Address>(
					new TextColumn<Address>() {
						@Override
						public String getValue(Address model) {
							Object value = model.getCountry();
							if (value == null) {
								return "";
							}
							return String.valueOf(value);
						}
					}, "Country");
			columnMetas.add(country_columnMeta);
			return columnMetas;
		}
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
      user_name.setReadOnly(readOnly);
      user_lastName.setReadOnly(readOnly);
      user_birthday.setReadOnly(readOnly);
      user_married.setEnabled(!readOnly);
      user_title.setReadOnly(readOnly);
      user_address.setReadOnly(readOnly);
   }
}
