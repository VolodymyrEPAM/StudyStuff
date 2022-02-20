Feature: As a user I want to verify payment process

  Scenario Outline: Check price correctness after adding product to cart
    Given I open book page by product code: <productCode>
    When I add current book to cart
    Then I see that '<expectedPrice>' is correct

    When I navigate to payment page and fill in '<email>' field
    Then I see all prices is correct:
      | Total     |
      | Sub-total |
      | VAT       |

    Examples:
      | expectedPrice | productCode   | email         |
      | 75.79         | 9780131872486 | test@user.com |