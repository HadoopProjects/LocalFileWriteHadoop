package com.rahul.localfilewritehadoop;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

public class LocalFileWriteHadoop {

	public static void main(String[] args) throws IOException {

		Configuration conf = new Configuration();
		
		InputStream in = new BufferedInputStream(new FileInputStream("/home/hadoop/data_map"));
	
		LocalFileSystem fs = FileSystem.getLocal(conf);
		OutputStream out = fs.create(new Path("/home/hadoop/BigData/localwrite"), new Progressable() {
			
			public void progress() {
				System.out.print(".");
				
			}
		});
		
		IOUtils.copyBytes(in, out, 4096,true);
	}

}
