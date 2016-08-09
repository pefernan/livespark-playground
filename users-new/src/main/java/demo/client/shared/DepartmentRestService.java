package demo.client.shared;

import org.livespark.formmodeler.rendering.client.shared.LiveSparkRestService;
import javax.ws.rs.Path;
import demo.client.shared.Department;
import java.util.List;

@Path("department")
public interface DepartmentRestService extends LiveSparkRestService<Department>
{
}