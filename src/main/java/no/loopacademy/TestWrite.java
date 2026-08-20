package no.loopacademy;

public class TestWrite implements Writer {
    private String test_field = "";

    public String getTest_field() {
        return test_field;
    }

    @Override
    public void write(String str) {
        this.test_field = str;
    }
    
}
