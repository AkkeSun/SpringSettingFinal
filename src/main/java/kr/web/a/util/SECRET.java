package kr.web.a.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.CharEncoding;

/* 
 * AES : Advanced Encryption Standard
 * AES-256 => 키가 256bit(=32byte)
 * 
 */

public class SECRET{
	
    public static void main(String[] args) throws Exception {
        String plainText = "저를 암호화 해주세요";
        String enc128 = AES_128_encrypt(plainText);
        String dec128 = AES_128_decrypt(enc128);
        String enc256 = AES_256_encrypt(plainText);
        String dec256 = AES_256_decrypt(enc256);
        System.out.println(plainText);
        System.out.println(enc128);
        System.out.println(dec128);
        System.out.println(enc256);
        System.out.println(dec256);
    }
	
    private final static String KEY = "340392837543210584321234759483209"; //32
    private final static String Alg = "AES/CBC/PKCS5Padding";
    private final static String KEY_128 = KEY.substring(0, 128 / 8); 
    private final static String KEY_256 = KEY.substring(0, 256 / 8); 
    
    
    // ---------------------AES 128 암호화 -----------------------
    public static String AES_128_encrypt(String plainText) throws Exception {
 
    	byte[] keyData = KEY_128.getBytes(CharEncoding.UTF_8);
    	
    	// AES Cipher 객채 생성
    	Cipher cipher = Cipher.getInstance(Alg);
    	
    	// 암호화 Chiper 초기화
        SecretKeySpec keySpec = new SecretKeySpec(keyData, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(keyData);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        // AES 암호화 
        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
        
        // base 64 인코딩
        String result = Base64.getEncoder().encodeToString(encrypted);
        return result;        
    }
    
    // ---------------------AES 128 복호화 -----------------------
    public static String AES_128_decrypt(String cipherText) throws Exception {
  
    	byte[] keyData = KEY_128.getBytes(CharEncoding.UTF_8);

        Cipher cipher = Cipher.getInstance(Alg);
        SecretKeySpec keySpec = new SecretKeySpec(keyData, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(keyData);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);
        
        byte[] decodedBytes =  Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
    
    
    // ---------------------AES 256 암호화 -----------------------
    public static String AES_256_encrypt(String plainText) throws Exception {
 
    	byte[] key128Data = KEY_128.getBytes(CharEncoding.UTF_8);
    	byte[] key256Data = KEY_256.getBytes(CharEncoding.UTF_8);

    	Cipher cipher = Cipher.getInstance(Alg);
    	
        SecretKeySpec keySpec = new SecretKeySpec(key256Data, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(key128Data);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);
        
        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }
    
    // ---------------------AES 256 복호화 -----------------------
    public static String AES_256_decrypt(String cipherText) throws Exception {
  
    	byte[] key128Data = KEY_128.getBytes(CharEncoding.UTF_8);
    	byte[] key256Data = KEY_256.getBytes(CharEncoding.UTF_8);

    	Cipher cipher = Cipher.getInstance(Alg);
    	
        SecretKeySpec keySpec = new SecretKeySpec(key256Data, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(key128Data);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);
        
        byte[] decodedBytes =  Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
    
}


