package com.cgy.mapreduce.outputFormatTest;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class FilterRecordWriter extends RecordWriter<Text, NullWritable> {

    FSDataOutputStream cgy =null;
    FSDataOutputStream other=null;
    public FilterRecordWriter(TaskAttemptContext job) {
        FileSystem fileSystem=null;
        try {
           fileSystem = FileSystem.get(job.getConfiguration());
             cgy = fileSystem.create(new Path("D:\\hadooptestfile\\out\\cgy.log"));
             other = fileSystem.create(new Path("D:\\hadooptestfile\\out\\other.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void write(Text key, NullWritable value) throws IOException, InterruptedException {
         String word = key.toString();
         if(word.contains("cgy")){
             cgy.writeBytes(word);
         }else{
             other.writeBytes(word);
         }
    }

    @Override
    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
        IOUtils.closeStream(cgy);
        IOUtils.closeStream(other);
    }
}
