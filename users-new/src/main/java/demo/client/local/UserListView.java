package demo.client.local;

import org.livespark.formmodeler.rendering.client.view.ListView;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import demo.client.shared.UserFormModel;
import demo.client.local.UserFormView;
import demo.client.shared.UserRestService;
import java.lang.Override;
import java.util.List;
import java.util.ArrayList;
import org.uberfire.ext.widgets.table.client.ColumnMeta;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.Column;
import org.uberfire.ext.widgets.table.client.CheckboxCellImpl;
import demo.client.shared.User;

@Templated
public class UserListView extends ListView<User, UserFormModel>
{

   @Override
   protected Class<UserFormView> getFormType()
   {
      return UserFormView.class;
   }

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
   protected Class<UserRestService> getRemoteServiceClass()
   {
      return UserRestService.class;
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
				new Column<User, Boolean>(married_columnMeta_checkbox) {
					@Override
					public Boolean getValue(User model) {
						Boolean value = model.getMarried();
						if (value == null) {
							return Boolean.FALSE;
						}
						return value;
					}
				}, "Marital Status");
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
   public User getModel(UserFormModel formModel)
   {
      return formModel.getUser();
   }

   @Override
   public UserFormModel createFormModel(User user)
   {
      UserFormModel formModel = new UserFormModel();
      formModel.setUser(user);
      return formModel;
   }
}