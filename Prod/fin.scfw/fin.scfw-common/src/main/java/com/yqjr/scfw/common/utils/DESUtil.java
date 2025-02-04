package com.yqjr.scfw.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * DES加密介绍 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现 。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */

public class DESUtil {
	private static Logger logger = LoggerFactory.getLogger(DESUtil.class);
	/**
	 * 加密
	 * 
	 * @param datasource
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 */
	public static byte[] encrypt(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param src
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}
	
	public static String encryptDESandBASE64(String str){
		// 密码，长度要是8的倍数
		String password = String.valueOf("879656985254785632145236");
		byte[] result = DESUtil.encrypt(str.getBytes(StandardCharsets.UTF_8), password);
		return MD5Utils.encode(Encodes.encodeBase64(result));
	}
	
	/**
	 * 对比token
	 * @param encryptStr 已加密token串
	 * @param decrypt 未加密token串
	 * @return
	 */
	public static boolean checkCSRFToken(String encryptStr ,String decrypt){
		String decryptDES = encryptDESandBASE64(decrypt);
		return decryptDES.equals(encryptStr);
	}
	
	// 测试
	public static void main(String args[]) {
		// 待加密内容
		String str = "测试内容";
		// 密码，长度要是8的倍数
		String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

		byte[] result = DESUtil.encrypt(str.getBytes(StandardCharsets.UTF_8), password);
		
		System.out.println("加密后：" + Encodes.encodeBase64(result));

		// 直接将如上内容解密
		try {
			byte[] decryResult = DESUtil.decrypt(result, password);
			System.out.println("解密后：" + new String(decryResult,StandardCharsets.UTF_8));
		} catch (Exception e1) {
			logger.error(e1.getMessage(),e1);
		}

	}
}
