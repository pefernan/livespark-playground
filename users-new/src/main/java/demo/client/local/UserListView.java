package demo.client.local;

import java.util.ArrayList;
import java.util.List;

import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.flow.cdi.api.Step;
import org.livespark.formmodeler.rendering.client.view.ListView;
import org.uberfire.ext.widgets.table.client.CheckboxCellImpl;
import org.uberfire.ext.widgets.table.client.ColumnMeta;

import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

import demo.client.shared.User;
import demo.client.shared.UserFormModel;

@Step
@Templated
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
		final List<ColumnMeta<User>> columnMetas = new ArrayList<>();
		final ColumnMeta<User> id_columnMeta = new ColumnMeta<>(
				new TextColumn<User>() {
					@Override
					public String getValue(final User model) {
						final Object value = model.getId();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "ID #");
		columnMetas.add(id_columnMeta);
		final ColumnMeta<User> name_columnMeta = new ColumnMeta<>(
				new TextColumn<User>() {
					@Override
					public String getValue(final User model) {
						final Object value = model.getName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Name");
		columnMetas.add(name_columnMeta);
		final ColumnMeta<User> lastName_columnMeta = new ColumnMeta<>(
				new TextColumn<User>() {
					@Override
					public String getValue(final User model) {
						final Object value = model.getLastName();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Last Name");
		columnMetas.add(lastName_columnMeta);
		final ColumnMeta<User> birthday_columnMeta = new ColumnMeta<>(
				new TextColumn<User>() {
					@Override
					public String getValue(final User model) {
						final Object value = model.getBirthday();
						if (value == null) {
							return "";
						}
						return String.valueOf(value);
					}
				}, "Birthday");
		columnMetas.add(birthday_columnMeta);
		final CheckboxCellImpl married_columnMeta_checkbox = new CheckboxCellImpl(
				true);
		final ColumnMeta<User> married_columnMeta = new ColumnMeta<>(
				new Column<User, Boolean>(married_columnMeta_checkbox) {
					@Override
					public Boolean getValue(final User model) {
						final Boolean value = model.getMarried();
						if (value == null) {
							return Boolean.FALSE;
						}
						return value;
					}
				}, "Marital Status");
		columnMetas.add(married_columnMeta);
		final ColumnMeta<User> title_columnMeta = new ColumnMeta<>(
				new TextColumn<User>() {
					@Override
					public String getValue(final User model) {
						final Object value = model.getTitle();
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
   public User getModel(final UserFormModel formModel)
   {
      return formModel.getUser();
   }

   @Override
   public UserFormModel createFormModel(final User user)
   {
      final UserFormModel formModel = new UserFormModel();
      formModel.setUser(user);
      return formModel;
   }

   @Override
    public User newModel() {
       return new User();
    }
}