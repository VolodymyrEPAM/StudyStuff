Feature: As a user I want to verify payment process

  Scenario Outline: Check price correctness after adding product to cart
    Given I open book page by product code: <productCode>
    When User adds current book to basket
    Then I see that '<expectedPrice>' is correct

    When I navigate to payment page and fill in '<email>' field
    Then User see that each price is correct:
      | Total     |
      | Sub-total |
      | VAT       |

    Examples:
      | expectedPrice | productCode   | email         |
      | 75.79         | 9780131872486 | test@user.com |