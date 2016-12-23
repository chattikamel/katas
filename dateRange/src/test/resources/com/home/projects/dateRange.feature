Feature: DateRange

  Scenario Outline: Same month

    Given a date range with start <start> ,and end <end>
    When I display the date range
    Then I should print "<message>"

    Examples:
    | start       | end         | message                      |
    |  Nov 9 16   |  Nov 14 16  |  Between November 9 and 14   |
    |  Jan 1 17   |  Jan 20 17  |  Between January 1 and 20    |

  Scenario: Different months

    Given  a date range with start Oct 9 16 ,and end Nov 14 16
    When I display the date range
    Then I should print "Between October 9 and November 14"

  Scenario: Differents years

    Given a date range with start Oct 9 15 ,and end Nov 14 16
    When I display the date range
    Then I should print "Between October 9, 2015 and November 14, 2016"

  Scenario Outline: End date is not defined and start date in the same year of current day

    Given a date range with start <start> ,and today is <today>
    When I display the date range
    Then I should print "<message>"

    Examples:
      | start         | today       | message                              |
      |  Nov 1 16     |  Nov 10 16  |  Tuesday, the 1st of November        |
      |  Jan 2 17     |  Jan 20 17  |  Monday, the 2nd of January          |
      |  Oct 3 17     |  Oct 20 17  |  Tuesday, the 3rd of October         |
      |  Feb 10 17    |  Oct 20 17  |  Friday, the 10th of February        |


  Scenario Outline: Otherwise

    Given a date range with start <start> ,and today is <today>
    When I display the date range
    Then I should print "<message>"

  Examples:
  | start         | today       | message                              |
  |  Nov 1 16     |  Nov 10 17  |  Tuesday, the 1st of November 2016   |
  |  Jan 2 17     |  Jan 20 18  |  Monday, the 2nd of January 2017     |
  |  Oct 3 17     |  Oct 20 18  |  Tuesday, the 3rd of October 2017    |
  |  Feb 10 17    |  Oct 20 18  |  Friday, the 10th of February 2017   |