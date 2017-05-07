import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESClient {

  private static final String ENCRYPT_KEY = "1234567890123456";
  private static final String ENCRYPT_IV = "abcdefghijklmnop";

  public static byte[] encrypt(byte[] byteText) {
    // 変数初期化
    byte[] byteResult = null;
    try {

      // 暗号化キーと初期化ベクトルをバイト配列へ変換
      byte[] byteKey = ENCRYPT_KEY.getBytes("UTF-8");
      byte[] byteIv = ENCRYPT_IV.getBytes("UTF-8");

      // 暗号化キーと初期化ベクトルのオブジェクト生成
      SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
      IvParameterSpec iv = new IvParameterSpec(byteIv);

      // Cipherオブジェクト生成
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

      // Cipherオブジェクトの初期化
      cipher.init(Cipher.ENCRYPT_MODE, key, iv);

      // 暗号化の結果格納
      byteResult = cipher.doFinal(byteText);


    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e) {
      e.printStackTrace();
    }

    // 暗号化文字列を返却
    return byteResult;
  }
  public static byte[] decrypt(byte[] byteText) {
    // 変数初期化
    String strResult = null;
    byte[] byteResult = null;
    try {

      // 暗号化キーと初期化ベクトルをバイト配列へ変換
      byte[] byteKey = ENCRYPT_KEY.getBytes("UTF-8");
      byte[] byteIv = ENCRYPT_IV.getBytes("UTF-8");

      // 復号化キーと初期化ベクトルのオブジェクト生成
      SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
      IvParameterSpec iv = new IvParameterSpec(byteIv);

      // Cipherオブジェクト生成
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

      // Cipherオブジェクトの初期化
      cipher.init(Cipher.DECRYPT_MODE, key, iv);

      // 復号化の結果格納
      byteResult = cipher.doFinal(byteText);

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e) {
      e.printStackTrace();
    }

    // 復号化文字列を返却
    return byteResult;
  }
}