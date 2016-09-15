package demo.client.local;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.TextColumn;
import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.flow.cdi.api.FlowComponent;
import org.livespark.formmodeler.rendering.client.view.ListView;
import org.uberfire.ext.widgets.table.client.ColumnMeta;

@Templated
@FlowComponent
public class AddressListView extends ListView<Address, AddressFormModel>
{

   @Override
   public String getListTitle()
   {
      return "Address";
   }

   @Override
   public String getFormTitle()
   {
      return "Address Form";
   }

   @Override
   protected String getFormId()
   {
      return "Address Form";
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

   @Override
   public Address getModel( AddressFormModel formModel)
   {
      return formModel.getAddress();
   }

   @Override
   public AddressFormModel createFormModel( Address address)
   {
      AddressFormModel formModel = new AddressFormModel();
      formModel.setAddress(address);
      return formModel;
   }

   public Address newModel()
   {
      return new Address();
   }
}
