package demo.server;

import demo.client.shared.Department;
import java.util.List;
import demo.client.shared.DepartmentRestService;
import javax.inject.Inject;
import javax.ejb.Stateless;
import java.lang.Override;

@Stateless
public class DepartmentRestServiceImpl implements DepartmentRestService
{

   @Inject
   private DepartmentEntityService entityService;

   @Override
   public Department create(Department model)
   {
      entityService.create(model);
      return model;
   }

   @Override
   public List<Department> load()
   {
      return entityService.listAll(Department.class);
   }

   @Override
   public Boolean update(Department model)
   {
      entityService.update(model);
      return true;
   }

   @Override
   public Boolean delete(Department model)
   {
      entityService.delete(model);
      return true;
   }
}