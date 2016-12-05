package testhadoop.testhadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.server.namenode.status_jsp;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import testhadoop.testhadoop.GrouupComparator.groupMap.groupReduce;

public class GrouupComparator {
	public static void main(String[] args) throws Exception {
		Configuration configuration=new Configuration();
		Job job=Job.getInstance();
		
		job.setJarByClass(GrouupComparator.class);
		
		job.setMapperClass(groupMap.class);
		job.setMapOutputKeyClass(SortBean.class);
		job.setMapOutputValueClass(LongWritable.class);
		
		job.setReducerClass(groupReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
		
		
	}
	
	
	
	
	public static class groupMap extends Mapper<LongWritable, Text, SortBean, LongWritable>{
		LongWritable k=new LongWritable();
		SortBean sortBean=new SortBean();
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] split = value.toString().split(",");
		
			sortBean.set(split[0], Integer.valueOf(split[1]));
			k.set(Integer.valueOf(split[1]));
			context.write(sortBean, k);
			
		}
	public static class groupReduce extends Reducer<SortBean, LongWritable, Text, LongWritable>{
		Text text=new Text();
		@Override
		protected void reduce(SortBean sortBean, Iterable<LongWritable> iterable,
				Context context)
				throws IOException, InterruptedException {
			for (LongWritable longWritable : iterable) {
				text.set(sortBean.getLeft());
				context.write(text, longWritable);
			}
			
			
		}
		
		
		
	}
		
		
		
	}
}
