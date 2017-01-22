package openjms;

import java.util.Hashtable;
 
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
 

public class QueueSend {
	 public static void main(String[] args) {
          try {
              //取得JNDI上下文和连接
              Hashtable properties = new Hashtable();
              properties.put(
                  Context.INITIAL_CONTEXT_FACTORY,
                  "org.exolab.jms.jndi.InitialContextFactory");
              //openJms默认的端口是1099
  //            properties.put(Context.PROVIDER_URL,"rmi://localhost:1099/");
              properties.put(Context.PROVIDER_URL,"tcp://localhost:3035/");
              Context context = new InitialContext(properties); 
              //获得JMS信息连接队列工厂
              QueueConnectionFactory queueConnectionFactory =
                  (QueueConnectionFactory) context.lookup("JmsQueueConnectionFactory");
              //获得JMS信息连接队列
              QueueConnection queueConnection =
                  queueConnectionFactory.createQueueConnection();
             //产生队列Session，设置事务为false，自动应答消息接收
              QueueSession queueSession =
                  queueConnection.createQueueSession(
                      false,
                      Session.AUTO_ACKNOWLEDGE);
  
              //获得默认内建在JMS里的队列之一：queue1
              Queue queue = (Queue) context.lookup("queue2");
              //产生JMS队列发送器
              QueueSender queueSender = 
                  queueSession.createSender(queue);
              //发送数据到JMS 
              UserBean ub = new UserBean();
              ub.setUsername("zhang");
              ub.setPassword("nopasdddddddddd");
              //当使用QueueReceiveAsynchronous的时候用这行，同时应把84行改为context.lookup(queue1)
  //            ObjectMessage message = queueSession.createObjectMessage(ub);
              //当使用QueueReceiveAsynchronous2的时候用这行，同时应把84行改为context.lookup(queue2)
              TextMessage message = queueSession.createTextMessage("123ttrr");
              queueSender.send(message);
              System.out.println("信息写入JMS服务器队列");
              //以下做清除工作，代码略
  //            queueSender.close();
 //            queueSession.close();
             //关闭connection后会自动关闭sender和session
             queueConnection.close();
         } catch (Exception e) {
             e.printStackTrace();
        }finally{
            System.exit(0);
        }
    }
}
