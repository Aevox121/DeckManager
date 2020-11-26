package DeckSave.DeckC;

public class Deck {
    private String DeckName;
    private String Profession;
    private Boolean IsStandard;
    private String DeckCode;
    private String IsStandardStr;
    private String DeckId;
    private String DeckCodeSlim;



    public Deck() {
    }

    public Deck(String deckName, String profession, String standard, String deckCode,String deckCodeSlim) {
        DeckName = deckName;
        Profession = profession;
        if(standard.contains("标准")){
            IsStandard = true;
        }
        else{
            IsStandard = false;
        }
        DeckCode = deckCode;
        DeckCodeSlim = deckCodeSlim;
    }

    public String getDeckCodeSlim() {
        return DeckCodeSlim;
    }

    public void setDeckCodeSlim(String deckCodeSlim) {
        DeckCodeSlim = deckCodeSlim;
    }

    public String getDeckName() {
        return DeckName;
    }

    public void setDeckName(String deckName) {
        DeckName = deckName;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getStandard() {
        if(IsStandard){
            return "标准";
        }
        else{
            return "狂野";
        }
    }

    public void setStandard(String standard) {
        if(standard.contains("��׼")){
            IsStandard = true;
        }
        else{
            IsStandard = false;
        }
    }

    public String getDeckCode() {
        return DeckCode;
    }

    public void setDeckCode(String deckCode) {
        DeckCode = deckCode;
    }

    public String getDeckId() {
        return DeckId;
    }

    public void setDeckId(String deckId) {
        DeckId = deckId;
    }
}
