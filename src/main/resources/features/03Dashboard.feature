Feature: Test some case in Dashboard
#T11
  Scenario: Tampilkan summary AI KC Depok
    When Atur tanggal
    And Pilih regionalnya
    And Pilih supervisi "KC Depok"
    And Klik tombol find result
    Then Validasi tampil "1080"

#    Examples:
#      | AI Type             | regional office | KC Supervisi | height               |
#      |sla_frontliner | Jakarta 2       | KC Depok     | 1080                 |
#      |sla_frontliner | Jakarta 2       | KC Bekasi    | 1080                 |
#      |sla_frontliner | Jakarta 2       | KC Cikampek  | Data is Empty        |
#      |queue          | Jakarta 2       | KC Bekasi    | 723                  |
#      | regional office | KC Supervisi | height               |
#      | Jakarta 2       | KC Depok     | 1080                 |
#      |Jakarta 2       | KC Bekasi    | 1080                 |
#      |Jakarta 2       | KC Cikampek  | Data is Empty        |
#T12
  Scenario: Tampilkan summary AI KC Bekasi
    When Atur tanggal
    And Pilih regionalnya
    And Pilih supervisi "KC Bekasi"
    And Klik tombol find result
    Then Validasi tampil "1080"
#T13
  Scenario: Tampilkan summary AI KC Cikampek
    When Atur tanggal
    And Pilih regionalnya
    And Pilih supervisi "KC Cikampek"
    And Klik tombol find result
    Then Validasi tampil "Data is Empty"
