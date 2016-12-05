package testhadoop.testhadoop;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;

public class SelectKnowledge extends Partitioner<Text, LongWritable>{

	@Override
	public int getPartition(Text arg0, LongWritable arg1, int arg2) {
		// TODO 自动生成的方法存根
		return 0;
	}



public class  WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
	
}
	

}