package airline.logic;

import airline.data.PaymentDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class PaymentModel 
{
  PaymentDao dao = PaymentDao.getInstance();
  
  private PaymentModel()
  {
  
  }

  public void create(Payment object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(Payment object)
  {
    dao.update(object);
  }
  
  public void destroy(Integer integer) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(integer);
  }
  
  public List<Payment> findAll()
  {
    return dao.findAll();
  }
  
  public List<Payment> findById(String id)
  {
    return dao.findById(id);
  }
  
  public List<Payment> findByName(String name)
  {
    return dao.findByName(name);
  }
  
  public static PaymentModel getInstance() 
  {
    return PaymentModelHolder.INSTANCE;
  }

  private static class PaymentModelHolder 
  {
    private static final PaymentModel INSTANCE = new PaymentModel();
  }
}
