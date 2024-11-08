Feature:Monitoring
#T19
  Scenario: masuk ke monitoring
    When Klik menu
    And Klik sub menu monitoring
    Then validasi halaman moni
#T20
  Scenario: masuk monitoring setting
    When klik tombol monitoring setting
    Then validasi monitoring setting
#T21
  Scenario: filter data monitoring
    When Pilih regional
    And Pilih supervisi
    And Pilih CCTV ID
    Then Validasi filter
#T22
  Scenario: masukkan cctv ke list
    When Klik action tabel
    Then validasi tampil di list
#T23
  Scenario: masukkan lebih dari 9 cctv
    When Klik action tabel lebih sembilan
    Then validasi maximum list
#T24
  Scenario: aktifkan cctv monitoring
    When pastikan ada cctv list
    And klik tombol done
    Then validasi tampil cctv