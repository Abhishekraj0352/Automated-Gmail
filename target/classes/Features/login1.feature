Feature: login page

Background: 
Given As a user I launch gmail
And As a user I click on gmail sign


Scenario: Validate with the help of compose feature,user is able to send an email successfully
When :I enter "numbhapsmile@gmail.com" and "Abhishek@123" 
And I click on compose button
And I enter recepient "abhishekraj0352@gmail.com" and subject as "Automation testing"
And I click on send button
And I verify email has been sent