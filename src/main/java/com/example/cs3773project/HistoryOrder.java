 public class OrderController {
    
      private IOrderService orderService;
  
     
      public void list(int cusid, HttpServletResponse response,int page,int rows) throws IOException {
          response.setContentType("text/html;charset=UTF-8");
          DatagridResult datagridResult = orderService.list(cusid,page,rows);
          response.getWriter().print(JSON.toJSONStringWithDateFormat(datagridResult, "yyyy-MM-dd HH:mm:ss"));
      }
     
      public void findById(int id,HttpServletResponse response) throws IOException {
          response.setContentType("text/html;charset=UTF-8");
          TCustomerOrder order = orderService.findById(id);
          response.getWriter().print(JSON.toJSONStringWithDateFormat(order, "yyyy-MM-dd HH:mm:ss"));
      }
  
  }

public interface IOrderService {
      
      DatagridResult list(int cusid, int page, int rows);
  
      TCustomerOrder findById(int id);
  
  }

public class OrderDetailsController {
     
      private IOrderDetailsService orderDetailsService;
    
      public Map getTotalPrice(int orderId){
          Map map = new HashMap();
          int totalMoney = orderDetailsService.getTotalPrice(orderId);
          map.put("totalMoney",totalMoney);
          return map;
      }
     
      public DatagridResult list(int orderId, int page, int rows){
          return orderDetailsService.selectOrderDetilsList(orderId,page,rows);
      }
  }


IOrderDetailsService

  public interface IOrderDetailsService {
     
      int getTotalPrice(int orderId);
  
      DatagridResult selectOrderDetilsList(int orderId, int page, int rows);
  }
