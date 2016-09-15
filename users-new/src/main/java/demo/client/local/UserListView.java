package demo.client.local;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import demo.client.shared.User;
import demo.client.shared.UserFormModel;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.flow.cdi.api.FlowComponent;
import org.livespark.formmodeler.rendering.client.view.ListView;
import org.uberfire.ext.widgets.table.client.CheckboxCellImpl;
import org.uberfire.ext.widgets.table.client.ColumnMeta;

@Templated
@FlowComponent
public class UserListView extends ListView<User, UserFormModel>
{

   @Override
   public String getListTitle()
   {
      return "User";
   }

   @Override
   public String getFormTitle()
   {
      return "User Form";
   }

   @Override
   protected String getFormId()
   {
      return "User Form";
   }

   @Override
	public List<ColumnMeta<User>> getCrudColumns() {
		List<ColumnMeta<User>> columnMetas = new ArrayList<>();
		ColumnMeta<User> id_columnMeta = new ColumnMeta<User>(
				new TextColumn<User>() {
					@Override
					public String getValue(User model) {
						Object value = model.getId();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "ID #");
		columnMetas.add(id_columnMeta);
		ColumnMeta<User> name_columnMeta = new ColumnMeta<User>(
				new TextColumn<User>() {
					@Override
					public String getValue(User model) {
						Object value = model.getName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Name");
		columnMetas.add(name_columnMeta);
		ColumnMeta<User> lastName_columnMeta = new ColumnMeta<User>(
				new TextColumn<User>() {
					@Override
					public String getValue(User model) {
						Object value = model.getLastName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Last Name");
		columnMetas.add(lastName_columnMeta);
		ColumnMeta<User> birthday_columnMeta = new ColumnMeta<User>(
				new TextColumn<User>() {
					@Override
					public String getValue(User model) {
						Object value = model.getBirthday();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Birthday");
		columnMetas.add(birthday_columnMeta);
		CheckboxCellImpl married_columnMeta_checkbox = new CheckboxCellImpl(
				true);
		ColumnMeta<User> married_columnMeta = new ColumnMeta<User>(
				new Column<User, Boolean>( married_columnMeta_checkbox) {
					@Override
					public Boolean getValue(User model) {
						Boolean value = model.getMarried();
						if (value == null) {
							return Boolean.FALSE;
						}
						return value;
					}
				}, "Married");
		columnMetas.add(married_columnMeta);
		ColumnMeta<User> title_columnMeta = new ColumnMeta<User>(
				new TextColumn<User>() {
					@Override
					public String getValue(User model) {
						Object value = model.getTitle();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Title");
		columnMetas.add(title_columnMeta);
		return columnMetas;
	}

   @Override
   public User getModel( UserFormModel formModel)
   {
      return formModel.getUser();
   }

   @Override
   public UserFormModel createFormModel( User user)
   {
      UserFormModel formModel = new UserFormModel();
      formModel.setUser(user);
      return formModel;
   }

   public User newModel()
   {
      return new User();
   }
}
