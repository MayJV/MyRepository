package testhadoop.testhadoop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HadoopTest {
	FileSystem fs=null;
	@Before
	public void getConf() throws IOException, InterruptedException, URISyntaxException{
		Configuration conf=new Configuration();
		fs=FileSystem.get(new URI("hdfs://zhang01:8020"), conf, "user01");
	}
	/*
	 * 下载
	 */
	@Test
	public void testDownload() throws IOException{
		FSDataInputStream in=fs.open(new Path("/input/wc.input"));
		FileOutputStream out=new FileOutputStream("d://wc.input");
		IOUtils.copyBytes(in, out, 4096, true);
		System.out.println("下载完成");
		
	}
	/*
	 * 上传 2016-11-22 16:10:41
	 */
	@Test
	public void testUpload() throws Exception{
		FSDataOutputStream out=fs.create(new Path("/output/dom.txt"), true);
		FileInputStream in =new FileInputStream("d://dom.txt");
		IOUtils.copyBytes(in, out, 4096,true);
	}
	/*
	 * 删除
	 */
	@Test
	public void testDel() throws Exception{
		boolean delete = fs.delete(new Path("/output/dom.txt"), true);
		System.err.println(delete);
		
	}
	/*
	 * 新建文件夹
	 */
	@Test
	public void testAddMkdir() throws Exception{
		boolean mkdirs = fs.mkdirs(new Path("/sb/sb"));
		System.out.println(mkdirs);
		
	}
}
