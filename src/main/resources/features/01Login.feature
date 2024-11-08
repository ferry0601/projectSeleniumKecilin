Feature: Check Login

  # T1
Scenario: Forgot Password
  Given User access the url "https://staging-briuker.kecilin.id/login"
  When Klik forgot password
  And Input email
  And Klik reset email
  Then validation reset

  # T2-T6
Scenario Outline: Login
  Given User access the url "https://staging-briuker.kecilin.id/login"
  When Input email "<email>"
  And Input password "<password>"
  And Klik show password
  And Klik remember me
  And Klik tombol login
  Then User see text validation "<result>" "<type>"

  Examples:
    | email                         | password        | result                                          | type      |
    |                               |                 | Semua kosong                                    | invalid   |
    |                               | s3creTpas&word  | Email kosong                                    | invalid   |
    | admindoangkecilin@yopmail.com |                 | Password kosong                                 | invalid   |
    | admindoangkecilin@yopmail.com | s3243ew         | These credentials do not match our records.     | invalid   |
    | admindoangkecilin@yopmail.com | s3creTpas&word  | Dashboard                                       | valid     |