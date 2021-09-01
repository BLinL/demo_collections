package utils;

import sun.misc.CRC16;

public class CrcUtil {

  private static final class Crc16IBM{
    private int ploy;
    private int initValue;
    private int xor;
    boolean inputReverse;
    boolean outputReverse;

    public Crc16IBM(int ploy, int initValue, int xor, boolean inputReverse, boolean outputReverse) {
      this.ploy = ploy;
      this.initValue = initValue;
      this.xor = xor;
      this.inputReverse = inputReverse;
      this.outputReverse = outputReverse;
    }
  }

  private static final Crc16IBM CRC_16_IBM = new Crc16IBM( 0x8005,0x0000,0x0000,true,true);
  public static void main(String[] args) {
    //crc16/ibm

    CRC16 crc16 = new CRC16();
    int crcCode = CRC16_IBM(new byte[]{1});
    System.out.println(crcCode);
  }


  public static int CRC16_IBM(byte[] buffer) {
    int wCRCin = 0x0000;
    int wCPoly = 0xa001;
    for (byte b : buffer) {
      wCRCin ^= ((int) b & 0x00ff);
      for (int j = 0; j < 8; j++) {
        if ((wCRCin & 0x0001) != 0) {
          wCRCin >>= 1;
          wCRCin ^= wCPoly;
        } else {
          wCRCin >>= 1;
        }
      }
    }
    return wCRCin ^= 0x0000;
  }

}
