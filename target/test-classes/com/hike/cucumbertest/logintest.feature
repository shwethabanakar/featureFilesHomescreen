@loginTest
Feature:To Test hike login functionality

Scenario:Login Functionality
Given:User has hike app installed ond environment as "ENVIRONMENT"
When:User logins using phonenumber as "PHONENUMBER"
Then:login should be successfull

Scenario:Login Functionality with msisdn lesser than 10 digit
Given:User has hike app installed ond environment as "ENVIRONMENT"
When:User logins using phonenumber as "PHONENUMBER"
Then:verify Internet connectivity popup