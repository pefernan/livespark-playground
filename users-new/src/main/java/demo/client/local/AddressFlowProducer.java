package demo.client.local;

import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import demo.client.shared.AddressRestService;
import org.livespark.flow.api.AppFlow;
import org.livespark.flow.api.Unit;
import org.livespark.formmodeler.rendering.client.flow.FlowProducer;
import org.livespark.formmodeler.rendering.client.flow.ForEntity;

public class AddressFlowProducer extends FlowProducer<Address, AddressFormModel, AddressFormView, AddressListView, AddressRestService>
{

   @Override
   public AddressFormModel modelToFormModel( Address model)
   {
      return new AddressFormModel( model);
   }

   @Override
   public Address formModelToModel( AddressFormModel formModel)
   {
      return formModel.getAddress();
   }

   @Override
   public Address newModel()
   {
      return new Address();
   }

   @Singleton
   @Produces
   public Class<Address> entityType()
   {
      return Address.class;
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.Address")
   @Named("create")
   public AppFlow<Unit, Optional<AddressFormModel>> create()
   {
      return super.create();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.Address")
   @Named("crud")
   public AppFlow<Unit, Unit> crud()
   {
      return super.crud();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.Address")
   @Named("createAndReview")
   public AppFlow<Unit, Unit> createAndReview()
   {
      return super.createAndReview();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("demo.client.shared.Address")
   @Named("view")
   public AppFlow<Unit, Unit> view()
   {
      return super.view();
   }
}
