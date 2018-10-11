/**
 * Copyright &copy; YQJR All rights reserved.
 */
package com.yqjr.scfw.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author Andy.Chen
 * @mail Chenjunjun.ZJ@gmail.com
 * 
 */
public class StreamUtils {
	private static Logger log = LoggerFactory.getLogger(StreamUtils.class);
	final static int BUFFER_SIZE = 4096;

	/**
	 * 将InputStream转换成String
	 * 
	 * @param in
	 *            InputStream
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String InputStreamTOString(InputStream in) {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		String string = null;
		int count = 0;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}

		data = null;
		return new String(outStream.toByteArray(), StandardCharsets.UTF_8);
	}

	/**
	 * 将InputStream转换成某种字符编码的String
	 * 
	 * @param in
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in, String encoding) {
		String string = null;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}

		data = null;
		try {
			string = new String(outStream.toByteArray(), encoding);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(),e);
		}
		return string;
	}

	/**
	 * 将String转换成InputStream
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static InputStream StringTOInputStream(String in) {
		return new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * 将String转换成InputStream
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static byte[] StringTObyte(String in) {
		byte[] bytes = null;
		try {
			bytes = InputStreamTOByte(StringTOInputStream(in));
		} catch (IOException e) {
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return bytes;
	}

	/**
	 * 将InputStream转换成byte数组
	 * 
	 * @param in
	 *            InputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		return outStream.toByteArray();
	}

	/**
	 * 将byte数组转换成InputStream
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static InputStream byteTOInputStream(byte[] in) {
		return new ByteArrayInputStream(in);
	}

	/**
	 * 将byte数组转换成String
	 * 
	 * @param in
	 * @return
	 */
	public static String byteTOString(byte[] in) {

		InputStream is = byteTOInputStream(in);
		return InputStreamTOString(is, StandardCharsets.UTF_8.name());
	}

	/**
	 * 将byte数组转换成String
	 * 
	 * @param in
	 * @return
	 */
	public static String getString(String in) {
		return byteTOString(StringTObyte(in));
	}

	// InputStream 转换成byte[]
	public byte[] getBytes(InputStream is) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = new byte[BUFFER_SIZE];
		int len = 0;

		while ((len = is.read(b, 0, BUFFER_SIZE)) != -1) {
			baos.write(b, 0, len);
		}

		baos.flush();


		return baos.toByteArray();
	}

	/**
	 * 根据文件路径创建文件输入流处理 以字节为单位（非 unicode ）
	 * 
	 * @param filepath
	 * @return
	 */
	public static InputStream getFileInputStream(String filepath) {
		InputStream is = null;
			Path path = Paths.get(filepath);
		try {
			is = java.nio.file.Files.newInputStream(path);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return is;
	}

	/**
	 * 根据文件对象创建文件输入流处理 以字节为单位（非 unicode ）
	 * 
	 * @param file
	 * @return
	 */
	public static InputStream getFileInputStream(File file) {
		InputStream is = null;
		try {
			is = java.nio.file.Files.newInputStream(file.toPath());
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return is;
	}

	/**
	 * 根据文件对象创建文件输出流处理 以字节为单位（非 unicode ）
	 * 
	 * @param file
	 * @param append
	 *            true:文件以追加方式打开,false:则覆盖原文件的内容
	 * @return
	 */
	public static OutputStream getFileOutputStream(File file, boolean append) {
		OutputStream os = null;
		try {
			if(append){
				os = java.nio.file.Files.newOutputStream(file.toPath(), StandardOpenOption.APPEND );
			}else{
				os = java.nio.file.Files.newOutputStream(file.toPath());
			}
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return os;
	}

	/**
	 * 根据文件路径创建文件输出流处理 以字节为单位（非 unicode ）
	 * 
	 * @param filepath
	 * @param append
	 *            true:文件以追加方式打开,false:则覆盖原文件的内容
	 * @return
	 */
	public static OutputStream getFileOutputStream(String filepath, boolean append) {
		OutputStream os = null;
		try {
			Path path = Paths.get(filepath);
			if(append){
				os = java.nio.file.Files.newOutputStream(path, StandardOpenOption.APPEND );
			}else{
				os = java.nio.file.Files.newOutputStream(path);
			}
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return os;
	}

	public static File getFile(String filepath) {
		return new File(filepath);
	}

	public static ByteArrayOutputStream getByteArrayOutputStream() {
		return new ByteArrayOutputStream();
	}

}