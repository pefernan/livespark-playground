package demo.server;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import demo.client.shared.Address;
import demo.client.shared.AddressRestService;
import org.livespark.formmodeler.rendering.client.shared.query.QueryCriteria;

@Stateless
public class AddressRestServiceImpl implements AddressRestService
{

   @Inject
   private AddressEntityService entityService;

   @Override
   public Address create( Address model)
   {
      return entityService.create(model);
   }

   @Override
   public List<Address> load()
   {
      return entityService.listAll(Address.class);
   }

   @Override
   public List<Address> list( QueryCriteria criteria ) {
      return entityService.list( Address.class, criteria );
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
