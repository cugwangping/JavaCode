package openjms;
import java.util.Hashtable;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
public class QueueReceiveSynchronous {
    public static void main(String[] args) {
        try {
            //取得JNDI上下文和连接
            Hashtable properties = new Hashtable();
            properties.put(
                Context.INITIAL_CONTEXT_FACTORY,
                "org.exolab.jms.jndi.InitialContextFactory");
//            properties.put(Context.PROVIDER_URL,"rmi://localhost:1099/");
            properties.put(Context.PROVIDER_URL,"tcp://localhost:3035/");
            Context context = new InitialContext(properties);

            //获得JMS信息连接队列工厂
            QueueConnectionFactory queueConnectionFactory =
                (QueueConnectionFactory) context.lookup(
                    "JmsQueueConnectionFactory");

            //获得JMS信息连接队列
            QueueConnection queueConnection =
                queueConnectionFactory.createQueueConnection();

            //启动接收队列线程
            queueConnection.start();
            //产生队列Session，设置事务为false，自动应答消息接收
            QueueSession queueSession =
                queueConnection.createQueueSession(
                    false,
                    Session.AUTO_ACKNOWLEDGE);
            //获得默认内建在JMS里的队列之一：queue1
            Queue queue = (Queue) context.lookup("queue2");
            //产生JMS队列接收器
            QueueReceiver queueReceiver =
                queueSession.createReceiver(queue);
            //通过同步的方法接收消息
            Message message = queueReceiver.receive();
            UserBean ub = null;
            if (message instanceof ObjectMessage){
                /*ub = (UserBean)((ObjectMessage)message).getObject();
                System.out.println("同步接收到：");
                System.out.println("username="+ub.getUsername());
                System.out.println("password="+ub.getPassword());*/
                System.out.println(((ObjectMessage) message).getObject());
            }
            //以下做清除工作
            message.clearBody();
            message.clearProperties();
            queueReceiver.close();
            queueSession.close();
            queueConnection.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}