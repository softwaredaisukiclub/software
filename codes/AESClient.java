import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
class AESClient{
  private static Key skey = makeKey(128);

  private static Key makeKey(int key_bits) {
    byte[] key = new byte[key_bits / 8];
    for (int i = 0; i < key.length; i++) {
      key[i] = (byte) (i + 1);
    }
    return new SecretKeySpec(key, "AES");
  }

  //暗号化
  public static byte[] encode(byte[] src) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, skey);
      return cipher.doFinal(src);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // 復号
  public static byte[] decode(byte[] src) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.DECRYPT_MODE, skey);
      return cipher.doFinal(src);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}