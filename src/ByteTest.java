
public class ByteTest {
    public static void main(String[] args) {
        byte b = -127;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b & 0xff)); //有符号数确保补0扩展

        int ucCRCHi = (0xffff & 0xFF00) >> 8;
        int ucCRCLo = 0xffff & 0xFF;
        System.out.println(ucCRCHi);
        System.out.println(ucCRCLo);
//        DecimalFormat df=new DecimalFormat("0.00");
//
//        System.out.println(df.format( ((float)5 / (float)2)));
//
//        byte[] byts = toBytes("1234");
//        for (int i = 0; i < byts.length; i++) {
//            System.out.print(byts[i] + " ");
//        }
    }

    //hexStr to bytes
    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public String toStr(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F'};

        //4位代表一个16进制，所以长度需要变为原来2倍
        char[] result = new char[bytes.length*2];

        int index = 0;
        for(byte b:bytes)
        {
            //先转换高4位
            result[index++] = hexDigits[(b>>>4)& 0xf];
            result[index++] = hexDigits[b& 0xf];
        }
        return new String(result);
    }

}
