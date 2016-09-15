package demo.server;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import demo.client.shared.User;
import demo.client.shared.UserRestService;
import org.livespark.formmodeler.rendering.client.shared.query.QueryCriteria;

@Stateless
public class UserRestServiceImpl implements UserRestService
{

   @Inject
   private UserEntityService entityService;

   @Override
   public User create( User model)
   {
      return entityService.create(model);
   }

   @Override
   public List<User> load()
   {
      return entityService.listAll(User.class);
   }

   @Override
   public List<User> list( QueryCriteria criteria ) {
      return entityService.list( User.class, criteria );
   }

   @Override
   public Boolean update(User model)
   {
      entityService.update(model);
      return true;
   }

   @Override
   public Boolean delete(User model)
   {
      entityService.delete(model);
      return true;
   }
}
