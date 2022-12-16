Feature: login page

Background: 
Given As a user I launch gmail
And As a user I click on gmail sign


Scenario: Validate with the help of compose feature,user is able to send an email successfully
When :I enter "<mail>" and "<password>" 
And I click on compose button
And I enter recepient "recepient mail" and subject as "Incubyte"
And I click on send button
And I verify email has been sent