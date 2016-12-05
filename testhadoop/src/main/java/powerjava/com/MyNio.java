package powerjava.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNio {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("d:/dom.txt");
		FileOutputStream fos=new FileOutputStream("d:/TEXT/ss.txt");
		FileChannel fic = fis.getChannel();
		FileChannel foc = fos.getChannel();
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		int len ;
		while ((len=fic.read(byteBuffer))!=-1) {
			byteBuffer.flip();
			foc.write(byteBuffer);
			byteBuffer.clear();
			
		}
		fic.close();foc.close();
		
	}

}
