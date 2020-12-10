package com.luban.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Ioxmh {
public static void main(String[] args) throws IOException, Exception {
//	OutputStream op = new FileOutputStream("a.txt");
//    ObjectOutputStream ops = new ObjectOutputStream(op);
//    ops.writeObject(new Personxmh("vae",1));
//     
//    ops.close();
	
	InputStream in = new FileInputStream("a.txt");
    ObjectInputStream os = new ObjectInputStream(in);
    byte[] buffer = new byte[10];
    int len = -1;
    Personxmh p = (Personxmh) os.readObject();
    System.out.println(p);  //Person [name=vae, age=1]
    os.close();
    
}

}
