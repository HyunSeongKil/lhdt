package lhdt.security;

import org.junit.jupiter.api.Test;

import java.util.Base64;

public class KeyManagerTest {

	@Test
	public void keyTest() throws Exception {
		String key = KeyManager.getInitKey();
		System.out.println(key);
		
		String encryptKey = "dGRobEAgc2kgZW1hbiB5bSAudGRobCByb2YgYWVkaSBkYWIgYSBla2FtIHRvbiBvZCBlc2FlbHAgLHllayB0ZXJjcyMgZG51b2YgZXZhaCB1b3kgZkk=";
		byte[] base64decodedBytes = Base64.getDecoder().decode(encryptKey.getBytes("UTF-8"));
		String result = new String(base64decodedBytes, "UTF-8");
		result = (new StringBuffer(result)).reverse().toString();
		System.out.println("1 ===== " + result);
		result = result.substring(81, 86) + result.substring(18, 24) + result.substring(25, 28);
		System.out.println("2 ===== " + result);
	}

	@Test
	public void 키_암호화() throws Exception {
		String key = "If you have found #scret key, please do not make a bad idea for lhdt. my name is @lhdt";
		System.out.println("key = " + key);
		String reverseKey =  new StringBuffer(key).reverse().toString();
		System.out.println("reverseKey = " + reverseKey);
		String encryptKey = new String(Base64.getEncoder().encode(reverseKey.getBytes("UTF-8")));
		System.out.println("encryptKey = " + encryptKey);
	}
}
