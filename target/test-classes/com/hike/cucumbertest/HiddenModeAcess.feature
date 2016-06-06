Story
As a user I should be able to access hidden mode via tapping on 'hi' from all 3 tabs
Acceptance Criteria
1. Hidden mode will be accessible via 'hi' on all the 3 tab
2. When a user taps on 'hi' on any of the screens, ask the user for password in that screen
 itself. On entering the password keep the user on that screen only
3. When setting up hidden mode, when we prompt the user with the tip 
to swipe left to hide the chat, slide the user to the the chats tab if the user was in some other tab.
4. Hidden mode when locked user will be on the same tab from where he has locked.


Scenario: Hidden Mode set up.
Give: User has hike app installed.
When: User taps on "hi" from tab < Tab foreground>
Then : User is always taken to the chat tab for the set up called Quick set up.

Example : 	| Tab Foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|

Scenario: Access hidden mode.
Give : User has Hike installed 
And: User has set up hidden mode.
And: Hidden mode is locked.
When: User taps on "hi" from tab < Tab foreground >
And: User enters the correct password.
Then: User lands on the < Tab Foreground > 

Example : 	| Tab Foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|

Scenario: Lock hidden mode.
Given: User has hike installed
And: User has set a hidden mode.
And: User has unlocked hidden mode successfully.
When: User is on < Tab Foreground >
And: Taps on "hi" to lock hidden mode.
Then : User should land on < Tab Foreground >

Example : 	| Tab Foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|
			
Scenario : User has hidden mode unlocked and backgrounds the app.
Given : User has Hike installed  with few hidden contacts.
And: Hidden mode is unlocked.
And: Hide chat on app exit is ON
When: User Backgrounds the app from < Screen Foreground >
And: Launches hike.
Then : User will land on the < Screen Foreground > With no hidden chats, posts , friend requests seen.

	
Example : 	|Screen  Foreground 	|
			| Chat Tab				|
			| Timeline				|
			| Added me				|	
			
Scenario : User has hidden mode unlocked and backgrounds the app.
Given : User has Hike installed with few hidden contacts.
And: Hidden mode is unlocked.
And: Hide chat on app exit is OFF
When: User Backgrounds the app from < Screen Foreground >
And: Launches hike.
Then : User will land on the < Screen Foreground > With  hidden chats, posts , friend requests seen.

	
Example : 	|Screen  Foreground 	|
			| Chat Tab				|
			| Timeline				|
			| Added me				|		
			
					
			

