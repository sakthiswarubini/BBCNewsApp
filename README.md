# Project Title

BBCNews Appium Automation

## Description

Appium automation for BBC News Android mobile application

## Installation & setup (One-Off)

1. Download Java
2. Download Android Studio
3. Download Node.JS
4. Setup system/environment variables for Java, Node and Android SDK
5. Open Android Studio and configure Emulator(in my scenario, its for OS Tiramisu)
6. Install and start the Appium server via Node 
7. Install Eclipse editor and setup Maven project with Appium client dependencies
8. Install cucumber plug-in from Eclipse market place
9. Setup the pom.xml file by adding the related dependencies

## Pre-requisites

1. Start the Appium server locally through command prompt( Appium )
2. Install .apk file in the Emulator through command prompt ( adb install bbcnews.apk )

## Process Steps

1. Open the app and manually sign-in for the first time
2. Test credentials given in the reference document (link below)
3. upon successful logon, user would be presented with the home page to start with
4. Automation process will then click on Video tab and validates "BBC News Channel"
5. And then does a page scroll down to validate "Copyright © 2018 BBC"
6. Clicks on Search icon and enters England, to validate the navigation bar text is the same as entered
7. Clicks on navigation back icon twice, to re-direct to home page and validates home page text
