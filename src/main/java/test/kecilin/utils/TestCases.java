package test.kecilin.utils;

public enum TestCases {
    T1("Forgot Password"),
    T2("Check Login semua kosong"),
    T3("Check Login email kosong"),
    T4("Check Login password kosong"),
    T5("Check Login akun tak terdaftar"),
    T6("Check Login valid"),
    T7("Check Total CCTV"),
    T8("invalid regional office"),
    T9("Show List Camera"),
    T10("download data filter and klik show CCTV"),
    T11("Tampilkan summary AI KC Depok"),
    T12("Tampilkan summary AI KC Bekasi"),
    T13("Tampilkan summary AI KC Cikampek"),
    T14("masuk ke reliability"),
    T15("tampil data reliability 0%"),
    T16("tampil data reliability greater than 98%"),
    T17("tampil data reliability greater than 0-100%"),
    T18("tampil data reliability regional jakarta 3"),
    T19("masuk ke monitoring"),
    T20("masuk monitoring setting"),
    T21("filter data monitoring"),
    T22("masukkan cctv ke list"),
    T23("masukkan lebih dari 9 cctv"),
    T24("aktifkan cctv monitoring"),
    T25("Logout"),
    T26(""),
    ;
    private String testCaseName;
    TestCases(String value){
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }
}
