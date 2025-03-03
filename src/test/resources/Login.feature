Feature: Feature for Testing the book library functionality of the application



  Scenario Outline: Validation of user is able to login with positive test data
    Given User navigates to the application
    When  User enters "<UserID>" and "<Password>"
    And   User navigates to Book List page
    And   User clicks on Add option to add book
    And   User add details "<Title>" "<Author>" "<ISBN>" "<Price>" "<Publicationdate>" "<Genre>"
    Then  Book with "<Title>" is displayed under the added list of homepage

    Examples:
      | UserID       |Password             |Title          |Author  |ISBN   |Price|    Publicationdate       |Genre       |
      |   admin1     |    securePassword   |  Automation   |   JK   |  abc  |  9   |      01/02/2025         |    Fiction |

  @sample
  Scenario Outline: Validating error message while adding books

    Given User enters "<UserID>" and "<Password>"
    And   User navigates to Book List page
    And   User clicks on Add option to add book
    And   User clicks on Add book button without entering the data
    Then  User is displayed with error "<message>"


    Examples:
      | UserID       |Password             |message                             |
      |   admin1     |    securePassword   |Please correct the following errors:|
