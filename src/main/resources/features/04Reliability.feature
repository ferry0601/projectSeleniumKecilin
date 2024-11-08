Feature: Reliability
#T14
  Scenario: masuk ke reliability
    When Klik menu
    And Klik sub menu
    Then validasi halaman reli
#T15
  Scenario: tampil data reliability 0%
    When Pilih filter "0%"
    And Input start date
    And Input end date
    And Input regional
    And Input KC supervisi
    And Klik tombol search
    Then validasi percentage "0%"
#T16
  Scenario: tampil data reliability greater than 98%
    When Pilih filter "98%"
    And Input start date
    And Input end date
    And Input regional
    And Input KC supervisi
    And Klik tombol search
    Then validasi percentage "98%"
#T17
  Scenario: tampil data reliability greater than 0-100%
    When Pilih filter "100%"
    And Input start date
    And Input end date
    And Input regional
    And Input KC supervisi
    And Klik tombol search
    Then validasi percentage "100%"
#T18
  Scenario: tampil data reliability regional jakarta 3
    When Pilih filter "max"
    And Input start date
    And Input end date
    And Input regional jakarta3
    And Input KC supervisi jakarta3
    And Klik tombol search
    Then validasi percentage "max"