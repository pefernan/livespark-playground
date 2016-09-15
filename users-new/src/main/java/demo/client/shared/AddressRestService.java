package demo.client.shared;

import javax.ws.rs.Path;

import org.livespark.formmodeler.rendering.client.shared.LiveSparkRestService;

@Path("address")
public interface AddressRestService extends LiveSparkRestService<Address>
{
}
