As a user I want to be notified about activity in the ME tab
Acceptance Criteria
1. There will be only 1 source of notification:
a. Added me
2. In case anyone adds me as a friend I will be shown a red dot with the count on
 the bottom tab icon of ME tab.Also a red dot will be shown on the added me option 
 inside the ME tab along with the count.
3. In case any one adds me as a friend and Hike is in Background. On tapping the notification , 
hike is launched and "added-me" tab is open 

Scenario: Added me notification and badge update within Hike app.
Given: User has hike app installed.
And: User has hike launched with < Screen Foreground > open.
When: User gets a friend request from contacts saved/unsaved.
Then: User sees a red dot with count on the Me-Tab icon below.

Example:	| Screen Foreground |
			| Chat Tab			|
			| Friends Tab		|
			
Scenario: Added me notification and badge update within Me-Tab.
Given: User has hike app installed.
And: User has hike launched with Me-Tab in Foreground.
When: User gets a friend request from contacts saved/unsaved.
Then: User sees a red dot with count on the Added-me icon.

Scenario : Added me notification when Hike is Background.
Given: User has hike with  non persistent screen < Screen Foreground> open.
And : User backgrounds the app.
When: User gets a notification for friend request from a contact saved/unsaved.
And: User taps on the notification.
Then: User is taken to the Added me screen.

Example : 	| Tab Foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|
			| Timeline			|
			| settings 			|
			| Activity 			|
			| Chat Thread		|
			| GC				|
			| Photo post 		|
			| Add friend		|
			| Edit DP 			|
			
Scenario : Added me notification when Hike is Killed.
Given: User has hike with screen Persistent/Non-persistent < Screen Foreground> open.
And : User kills the app.
When: User gets a notification for friend request from a contact saved/unsaved.
And: User taps on the notification.
Then: User is taken to the Added me screen.

Example : 	| Screen foreground |
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|
			| Timeline			|
			| settings 			|
			| Activity 			|
			| Chat Thread		|
			| GC				|
			| Photo post 		|
			| Add friend		|
			| Edit DP 			|
			| Compose Status	|
			
Scenario: User gets a friend request from hidden contact.
Given : User has hike installed.
And: User has some hidden chats.
And: User is on non persistent < Screen foreground > open.
And: User Backgrounds the app.
When: User gets a notification for friend request from a hidden contact.
And: User taps on the notification.
Then: User is taken to the Chat Tab

Example : 	|Screen foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|
			| Timeline			|
			| settings 			|
			| Activity 			|
			| Chat Thread		|
			| GC				|
			| Photo post 		|
			| Add friend		|
			| Edit DP 			|
			
Scenario: User gets a friend request from hidden contact.
Given : User has hike installed.
And: User has some hidden chats.
And: User is on non persistent < Screen foreground > open.
And: User Backgrounds the app.
When: User gets a notification for friend request from a hidden contact.
And: User taps on the notification.
And: User is taken to the Chat Tab where user unlocks the hidden mode.
Then: A red dot with count on the Me-Tab icon below is seen.

Example : 	|Screen foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|
			| Timeline			|
			| settings 			|
			| Activity 			|
			| Chat Thread		|
			| GC				|
			| Photo post 		|
			| Add friend		|
			| Edit DP 			|
			
Scenario: User gets a friend request from hidden contact.
Given : User has hike installed.
And: User has some hidden chats.
And: User is on non persistent < Screen foreground > open.
And: User Backgrounds the app.
When: User gets a notification for friend request from a hidden contact.
And: User taps on the notification.
And: User is taken to the Chat Tab where user unlocks the hidden mode.
And:  A red dot with count on the Me-Tab icon below is seen.
And: User Taps on Me tab.
Then: User will see a count update on Added me icon .

Example : 	|Screen foreground 	|
			| Chat Tab			|
			| Friends Tab		|
			| Me tab			|
			| Timeline			|
			| settings 			|
			| Activity 			|
			| Chat Thread		|
			| GC				|
			| Photo post 		|
			| Add friend		|
			| Edit DP 			|


Scenario : Added me notification when Hike is Killed.
Given : User has hike installed.
And: User has some hidden chats.
And: User is on screen < Screen foreground > open.
And : User kills the app.
When: User gets a notification for friend request from a contact saved/unsaved.
And: User taps on the notification.
Then: User is taken to the Chat Tab screen.

Example : 	| Screen foreground 	|
			| Chat Tab				|
			| Friends Tab			|
			| Me tab				|
			| Timeline				|
			| settings 				|
			| Activity 				|
			| Chat Thread			|
			| GC					|
			| Photo post 			|
			| Add friend			|
			| Edit DP 				|
			| Compose Status		|
			

Scenario:badge counter on <screen> tab gets removed once user navigate to <screen> tab from chats tab and returns
Given user is on chat screen
And there is badge counter on <screen> tab icon
When user taps on navigates to <screen> tab and returns to chat tab
Then verify that no badge counter is present on <screen> tab icon

Examples:	| screen  |
			| friends |
			| me      |


Scenario:badge counter on <screen> tab gets removed once user navigate to <screen> tab from friends tab and returns
Given user is on friends screen
And there is badge counter on <screen> tab icon
When user taps on navigates to <screen> tab and returns to friends tab
Then verify that no badge counter is present on <screen> tab icon

Examples: 	| screen       | 
			| conversation |
			| me           |
			


			


