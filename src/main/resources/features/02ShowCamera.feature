Feature: Show Camera
#T7
  Scenario: Check Total CCTV
    When Klik Total CCTV
    Then Get validation
#T8
  Scenario: invalid regional office
    When Klik regional office
    And Input option
    Then Validasi regional
#T9
  Scenario: Show List Camera
#    When Klik regional office
    And Select option dari list Regional Office
#    And Result "Yogyakarta Test" harus tampil
    Then Validation result
#T10
  Scenario: download data filter and klik show CCTV
    When Klik tombol export
#    Then Validasi download
    And Show CCTV
    Then Validasi show CCTV
