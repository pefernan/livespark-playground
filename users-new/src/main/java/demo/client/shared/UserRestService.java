package demo.client.shared;

import javax.ws.rs.Path;

import org.livespark.formmodeler.rendering.client.shared.LiveSparkRestService;

@Path("user")
public interface UserRestService extends LiveSparkRestService<User>
{
}
