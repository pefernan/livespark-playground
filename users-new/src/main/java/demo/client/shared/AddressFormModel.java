package demo.client.shared;

import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.livespark.formmodeler.rendering.client.shared.FormModel;

@Portable
@Bindable
@Named("AddressFormModel")
public class AddressFormModel extends FormModel
{

   @Valid
   private Address address;

   public Address getAddress()
   {
      return address;
   }

   public void setAddress(Address address)
   {
      this.address = address;
   }

   public AddressFormModel()
   {
   }

   public AddressFormModel(@MapsTo("address") Address address)
   {
      this.address = address;
   }

   @Override
   public List<Object> getDataModels()
   {
      return Arrays.<Object> asList(address);
   }
}
