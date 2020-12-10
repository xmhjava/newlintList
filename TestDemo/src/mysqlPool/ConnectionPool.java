package mysqlPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class ConnectionPool {
	public static void main(String[] args) {
		ConnectionPool pool=new ConnectionPool();
		
	}
    private LinkedList<Connection> connections=new LinkedList<Connection>();
    //Ĭ�ϵ����ݿ����ӳش�СΪ5
    private static int initSize=5;
    private static int maxSize=5;
    private  int acturalSize=0;//���ݿ����ӳص�ʵ�ʴ�С
    private static Properties props = null;
    static{
        try {
        	props = new Properties();
            InputStream in = ConnectionPool.class.getClassLoader()
                    .getResourceAsStream("jdbc.properties");
            System.out.println("===in=="+in);
            props.load(in);
        } catch(Exception e) {
           // throw new RuntimeException(e);
        	System.out.println("========="+e);
        }
        
        try {
            String size=props.getProperty("initSize");
            String size2=props.getProperty("maxSize");
            if(size!=null){
                initSize=Integer.parseInt(size);
            }
            if(size2!=null){
                maxSize=Integer.parseInt(size2);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //��ȡ���ӵľ�̬�ڲ���
    static class GetCon{
        static{
            try {
                Class.forName(props.getProperty("driverClassName"));
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        static java.sql.Connection getConnection() throws SQLException{
            return  DriverManager.getConnection(props.getProperty("url"),
                    props.getProperty("username"), 
                    props.getProperty("password"));
        }
    }
    public ConnectionPool(){
        //��ʼ�����ݿ����ӳ�
    	System.out.println("==initSize=="+initSize);
        for (int i = 0; i<initSize; i++) {
            try {
                connections.addLast((Connection) GetCon.getConnection());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            acturalSize++;
            
        }
    }
    /**
     * �÷��������ͷ����ӣ���connection����Żص����ݿ����ӳ�,ʵ�ֶ����ݿ����ӳش��С������
     * @param connection Ҫ�Ż����ݿ����ӳص�����
     */
    public void releseConnection(Connection connection){
        if(connection!=null){
            synchronized (connections) {
                if(connections.size()>initSize){
                    try {
                        connection.close();
                        acturalSize--;
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }else{
                    connections.addLast(connection);
                }
                
                connections.notifyAll();//�������еȴ���ȡ���ӵĶ���
            }
        }
    }
    /**
     * �÷������������ݿ����ӳػ�ȡ����
     * @param mills ��ȡ���ӵĳ�ʱʱ�� ��λ����,�����õ�ֵΪ0ʱ�򣬼���Ҫ��ȴ�ʱ��
     * @return connection����
     * @throws SQLException 
     * @throws InterruptedException 
     */
    public java.sql.Connection getConnection(long mills) throws SQLException, InterruptedException{
        synchronized (connections) {
            if(mills<=0){
                while (connections.isEmpty()) {
                    if(acturalSize<maxSize){
                        java.sql.Connection con= DriverManager.getConnection(props.getProperty("url"),
                                props.getProperty("username"), 
                                props.getProperty("password"));
                        acturalSize++;
                        return con;
                    }else{
                        connections.wait();
                    }
                }
                return connections.removeFirst();
            }else{
                if(acturalSize<maxSize){
                    java.sql.Connection con= DriverManager.getConnection(props.getProperty("url"),
                            props.getProperty("username"), 
                            props.getProperty("password"));
                    acturalSize++;
                    return con;
                }else{
                    long future=System.currentTimeMillis()+mills;
                    long remaining=mills;
                    while(connections.isEmpty()&&remaining>0){
                        connections.wait(remaining);
                        remaining=future-System.currentTimeMillis();
                    }
                    Connection result=null;
                    if(!connections.isEmpty()){
                        result=connections.removeFirst();
                    }
                    return result;
                }
            }
        }
    }
}
