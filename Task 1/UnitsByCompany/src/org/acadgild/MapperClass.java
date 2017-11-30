package org.acadgild;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperClass extends Mapper <LongWritable, Text, Text, IntWritable>
{
	private static final String NOT_AVAILABLE = "NA";
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		System.out.println("value: "+value);
		String line = value.toString();
		System.out.println("line: "+line);
		if(line.length()>0)
		{
			String[] fields = line.split("\\|");
			String companyName = fields[0];
			IntWritable count = new IntWritable(1);
			if(!companyName.equals(NOT_AVAILABLE))
			{				
				context.write(new Text(companyName), count);
			}
	
		}
	}
}