package demo.client.local;

import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

import demo.client.shared.User;
import demo.client.shared.UserFormModel;
import demo.client.shared.UserRestService;
import org.livespark.flow.api.AppFlow;
import org.livespark.flow.api.Unit;
import org.livespark.formmodeler.rendering.client.flow.FlowProducer;
import org.livespark.formmodeler.rendering.client.flow.ForEntity;

public class UserFlowProducer extends FlowProducer<User, UserFormModel, UserFormView, UserListView, UserRestService>
{

   @Override
   public UserFormModel modelToFormModel( User model)
   {
      return new UserFormModel( model);
   }

   @Override
   public User formModelToModel( UserFormModel formModel)
   {
      return formModel.getUser();
   }

   @Override
   public User newModel()
   {
      return new User();
   }

   @Singleton
   @Produces
   public Class<User> entityType()
   {
      return User.class;
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.User")
   @Named("create")
   public AppFlow<Unit, Optional<UserFormModel>> create()
   {
      return super.create();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.User")
   @Named("crud")
   public AppFlow<Unit, Unit> crud()
   {
      return super.crud();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.User")
   @Named("createAndReview")
   public AppFlow<Unit, Unit> createAndReview()
   {
      return super.createAndReview();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.User")
   @Named("view")
   public AppFlow<Unit, Unit> view()
   {
      return super.view();
   }
}
