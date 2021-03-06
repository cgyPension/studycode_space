package com.cgy.mapreduce.wordcountpartitionandsort.partitionerAtoZ;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountAMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    private Text outK=new Text();
    private IntWritable outV=new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final String line = value.toString();
        final String[] words = line.split(" ");
        for (String word : words) {
            outK.set(word);
            // 往环形缓冲区中写入数据
            context.write(outK,outV);
        }
    }
}
