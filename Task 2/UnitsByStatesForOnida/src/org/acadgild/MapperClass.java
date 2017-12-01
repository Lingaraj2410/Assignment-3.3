package org.acadgild;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperClass extends Mapper <LongWritable, Text, Text, IntWritable>
{
	private static final String COMPANY = "Onida";
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String line = value.toString();
		if(line.length()>0)
		{
			String[] fields = line.split("\\|");
			String companyName = fields[0];
			String stateName = fields[3];
			IntWritable count = new IntWritable(1);
			if(companyName.equals(COMPANY))
			{				
				context.write(new Text(stateName), count);
			}
	
		}
	}
}
