package openjms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueReceiveAsynchronous implements MessageListener {
    private UserBean ub = null;
    QueueReceiveAsynchronous(){
        try {
            //取得JNDI上下文和连接
            Hashtable properties = new Hashtable();
            properties.put(
                Context.INITIAL_CONTEXT_FACTORY,
                "org.exolab.jms.jndi.InitialContextFactory");
            properties.put(Context.PROVIDER_URL, 
                "rmi://localhost:1099/");
            Context context = new InitialContext(properties);
            //获得JMS信息连接队列工厂
            QueueConnectionFactory queueConnectionFactory =
                (QueueConnectionFactory) context.lookup(
                    "JmsQueueConnectionFactory");
            //获得JMS信息连接队列
            QueueConnection queueConnection =
                queueConnectionFactory.createQueueConnection();
            //产生队列Session，设置事务为false，自动应答消息接收
            QueueSession queueSession =
                queueConnection.createQueueSession(
                    false,Session.AUTO_ACKNOWLEDGE);
            //获得默认内建在JMS里的队列之一：queue1
            Queue queue = (Queue) context.lookup("queue1");
            //产生JMS队列接收器
            QueueReceiver queueReceiver =
                queueSession.createReceiver(queue);
            queueReceiver.setMessageListener(this);
            //启动接收队列线程
            queueConnection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("非同步消息的接收：");
        try {
            QueueReceiveAsynchronous listener =
                new QueueReceiveAsynchronous();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onMessage(Message message) {
        if (message instanceof ObjectMessage){
            try {
                ub = (UserBean)((ObjectMessage)message).getObject();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            if(ub != null){
                System.out.println("username="+ub.getUsername());
                System.out.println("password="+ub.getPassword());
                ub = null;
            }
        }
    }
}