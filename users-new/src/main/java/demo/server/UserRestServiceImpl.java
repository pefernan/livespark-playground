package demo.server;

import demo.client.shared.User;
import java.util.List;
import demo.client.shared.UserRestService;
import javax.inject.Inject;
import javax.ejb.Stateless;
import java.lang.Override;

@Stateless
public class UserRestServiceImpl implements UserRestService
{

   @Inject
   private UserEntityService entityService;

   @Override
   public User create(User model)
   {
      entityService.create(model);
      return model;
   }

   @Override
   public List<User> load()
   {
      return entityService.listAll(User.class);
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