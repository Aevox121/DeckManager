package DeckSave.DeckC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeckAnalysis {
    public static Deck fromFile(String address) {
        char c[] = new char[1000];
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(address), "utf-8"));
            in.read(c);
            //System.out.println(c);
            in.close();
        } catch (IOException e) {
            System.out.println("读取失败：" + e);
        }

        //转换成字符串方便分析
        String DeckCode = new String(c);

        Deck deck = DeckAnalysis.fromString(DeckCode);

        return deck;
    }

    public static Deck fromString(String DeckCode){
        //把空格去掉
        String reDeckCode = DeckCode.replace(" ", "");
        //找到简略代码
        int index = reDeckCode.lastIndexOf("#");
        int endIndex = reDeckCode.lastIndexOf("#",index-1);
        int beginIndex = reDeckCode.lastIndexOf("#",endIndex-1);
        String DeckCodeSlim = reDeckCode.substring(beginIndex+1,endIndex);


        //System.out.println(reDeckCode);

        //用#分割开字符串存入数组，方便找数据
        String[] DCS = reDeckCode.split("[#]");
        /*检查数组里的元素
        for(int i = 0;i < DCS.length;i++){
            System.out.println(i + DCS[i]);
        }
        */
        //把职业和模式替换出来
        String DeckName = DCS[3];
        String Profession = (DCS[4].replace("职业：",""));
        String Standard = (DCS[5].replace("模式：",""));

        Deck deck = new Deck(DeckName,Profession,Standard,DeckCode,DeckCodeSlim);
                /*检查套牌类里的元素
        System.out.println(deck.getDeckName());
        System.out.println(deck.getProfession());
        System.out.println(deck.getStandard());
        System.out.println(deck.getDeckCode());
        */

        return deck;
    }

    public static String slim(String DeckCode){
        String reDeckCode = DeckCode.replace(" ", "");
        int index = reDeckCode.lastIndexOf("#");
        int endIndex = reDeckCode.lastIndexOf("#",index-1);
        int beginIndex = reDeckCode.lastIndexOf("#",endIndex-1);
        String DeckCodeSlim = reDeckCode.substring(beginIndex+1,endIndex);
        return DeckCodeSlim;
    }

}
