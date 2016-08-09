package demo.server;

import demo.client.shared.Address;
import java.util.List;
import demo.client.shared.AddressRestService;
import javax.inject.Inject;
import javax.ejb.Stateless;
import java.lang.Override;

@Stateless
public class AddressRestServiceImpl implements AddressRestService
{

   @Inject
   private AddressEntityService entityService;

   @Override
   public Address create(Address model)
   {
      entityService.create(model);
      return model;
   }

   @Override
   public List<Address> load()
   {
      return entityService.listAll(Address.class);
   }

   @Override
   public Boolean update(Address model)
   {
      entityService.update(model);
      return true;
   }

   @Override
   public Boolean delete(Address model)
   {
      entityService.delete(model);
      return true;
   }
}